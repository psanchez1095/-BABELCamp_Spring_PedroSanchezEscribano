package service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.AlumnosDao;
import dao.CursosDao;
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
	public List<Curso> cursos() {
		List<Curso> list = daoCursos.findAll();
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
		/*Alumno alumno = daoAlumnos.findById(usuario).orElse(null);
		Curso curso = daoCursos.findById(idCurso).orElse(null);
		
		if (alumno != null && curso != null) {
			System.out.println(alumno+"   "+curso);
			alumno.getCursos().add(curso);
			daoAlumnos.save(alumno);
			return true;
		}
		else return false;*/
		
		Optional<Alumno> alumno = daoAlumnos.findById(usuario);
		Optional<Curso> curso = daoCursos.findById(idCurso);
		
		if (alumno.isPresent() && curso.isPresent()) {
			System.out.println(alumno+"   "+curso);
			alumno.get().getCursos().add(curso.get());
			daoAlumnos.save(alumno.get());
			return true;
		}
		else return false;
	}

	@Override
	public Alumno buscarAlumno(String usuario) {
		return daoAlumnos.findById(usuario).orElse(null);
	}

	@Override
	public Curso buscarCurso(int id) {
		return daoCursos.findById(id).orElse(null);

	}

	@Override
	public List<Alumno> alumnos() {
		List<Alumno> list = daoAlumnos.findAll();
		return list.size() > 0 ? list : null;
	}
}
