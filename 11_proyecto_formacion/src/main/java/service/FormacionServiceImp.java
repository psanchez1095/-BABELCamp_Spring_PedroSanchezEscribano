package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.AlumnosDao;
import dao.AlumnosDaoImp;
import dao.CursosDao;
import dao.CursosDaoImp;
import model.Alumno;
import model.Curso;

@Service
public class FormacionServiceImp implements FormacionService {

	
	CursosDao daoCursos;
	AlumnosDao daoAlumnos;
	
	public FormacionServiceImp(@Autowired CursosDao daoCursos, @Autowired AlumnosDao daoAlumnos) {
		super();
		this.daoCursos = daoCursos;
		this.daoAlumnos = daoAlumnos;
	}

	@Override
	public List<String> cursos() {
		List<String> list = daoCursos.findAll();
		return list.size() > 0 ? list : null;
	}

	@Override
	public List<Alumno> alumnosCurso(String nombreCurso) {
		List<Alumno> list = daoAlumnos.findByCurso(nombreCurso);
		return list.size() > 0 ? list : null;
	}

	@Override
	public List<Curso> cursoMatriculadoAlumno(String usuario) {
		List<Curso> list = daoCursos.findByAlumno(usuario);
		return list.size() > 0 ? list : null;
	}

	@Override
	public Alumno validarUsuario(String usuario, String contraseña) {
		return daoAlumnos.findByUsuarioAndPassword(usuario, contraseña);
	}

	
	@Override
	@Transactional
	public boolean matricularAlumno(String usuario, int idCurso) {
		Alumno alumno = daoAlumnos.findById(usuario);
		Curso curso = daoCursos.findById(idCurso);
		
		if (alumno != null && curso != null) {
			System.out.println(alumno+"   "+curso);
			alumno.getCursos().add(curso);
			daoAlumnos.update(alumno);
			return true;
		}
		else return false;
	}

	@Override
	public Alumno buscarAlumno(String usuario) {
		return daoAlumnos.findById(usuario);
	}

	@Override
	public Curso buscarCurso(int id) {
		return daoCursos.findById(id);

	}

	@Override
	public List<Alumno> alumnos() {
		List<Alumno> list = daoAlumnos.findAll();
		return list.size() > 0 ? list : null;
	}
}
