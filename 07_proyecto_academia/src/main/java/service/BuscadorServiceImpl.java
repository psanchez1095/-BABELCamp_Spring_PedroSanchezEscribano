package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import model.Alumno;


//Instancia una clase mediante Spring
@Service
public class BuscadorServiceImpl implements BuscadorService {
	
	@Autowired
	JdbcTemplate template;

	public BuscadorServiceImpl() {
	}

	@Override
	public List<Alumno> buscar(String curso) {
		 return template.query("SELECT * FROM alumnos WHERE curso LIKE ?", 
				 (rs,f)->new Alumno(rs.getInt("idAlumno"),
						 rs.getString("nombre"),
						 rs.getString("curso"),
						 rs.getInt("nota")),
				 curso);
	}

	@Override
	public void alta(Alumno p) {
		if(!existeAlumno(p.getNombre())) {
		String sql ="insert into alumnos(nombre,curso,nota) values(?,?,?)";
		template.update(sql, p.getNombre(),p.getCurso(),p.getNota());
		}
	}

	@Override
	public void baja(String nombre) {
		String sql ="delete from alumnos where nombre = ?";
		template.update(sql, nombre);

	}

	@Override
	public void modificar(Alumno p) {
		String sql ="update alumnos set precio = ? where nombre = ?";
		template.update(sql, p.getNota(),p.getNombre());
	}

	@Override
	public Alumno buscar(int id) {
		List<Alumno> list  = template.query("SELECT * FROM alumnos WHERE id LIKE ?", 
				 (rs,f)->new Alumno(rs.getInt("idAlumno"),
				 rs.getString("nombre"),
				 rs.getString("curso"),
				 rs.getInt("nota")),
				 id);
		return list.size()>0 ? list.get(0) : null;
	}

	@Override
	public boolean existeAlumno(String nombre) {
		List<Alumno> list  = template.query("SELECT * FROM alumnos WHERE nombre LIKE ?", 
				 (rs,f)->new Alumno(rs.getInt("idAlumno"),
				 rs.getString("nombre"),
				 rs.getString("curso"),
				 rs.getInt("nota")),
				 nombre);
		return list.size()>0 ? true : false;
	}

	@Override
	public List<String> cursos() {
		String sql = "select distinct(curso) from alumnos";
		return template.query(sql, (r,f)->r.getString(1));
	}


}
