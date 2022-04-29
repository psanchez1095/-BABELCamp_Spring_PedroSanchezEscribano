package service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import converters.ConversorEntityDto;
import dao.AlumnosDao;
import dao.CursosDao;
import dtos.AlumnoDto;
import dtos.CursoDto;
import model.Alumno;
import model.Curso;

@Service
public class FormacionServiceImp implements FormacionService {
	
	@Autowired ConversorEntityDto conversor;
	CursosDao daoCursos;
	AlumnosDao daoAlumnos;

	public FormacionServiceImp(@Autowired CursosDao daoCursos, @Autowired AlumnosDao daoAlumnos) {
		super();
		this.daoCursos = daoCursos;
		this.daoAlumnos = daoAlumnos;
	}

	@Override
	public List<CursoDto> cursos() {
		return daoCursos.findAll()
		.stream()
		.map(a->conversor.cursoToDto(a))
		.collect(Collectors.toList());
	}

	@Override
	public List<AlumnoDto> alumnosCurso(String nombreCurso) {
		return daoAlumnos.findByCurso(nombreCurso)
				.stream()
				.map(a->conversor.alumnoToDto(a))
				.collect(Collectors.toList());
		
	}

	@Override
	public List<CursoDto> cursoMatriculadoAlumno(String usuario) {
		return daoCursos.findByAlumno(usuario)
		.stream()
		.map(a->conversor.cursoToDto(a))
		.collect(Collectors.toList());
	}

	@Override
	public List<CursoDto> cursoNoMatriculadoAlumno(String usuario) {
		return daoCursos.findByAlumnoNoMatriculado(usuario)
		.stream()
		.map(a->conversor.cursoToDto(a))
		.collect(Collectors.toList());
	}

	@Override
	public AlumnoDto validarUsuario(String usuario, String contraseña) {
		return conversor.alumnoToDto(daoAlumnos.findByUsuarioAndPassword(usuario, contraseña));
	}

	@Override
	@Transactional
	public boolean matricularAlumno(String usuario, int idCurso) {
		/*
		 * Alumno alumno = daoAlumnos.findById(usuario).orElse(null); Curso curso =
		 * daoCursos.findById(idCurso).orElse(null);
		 * 
		 * if (alumno != null && curso != null) {
		 * System.out.println(alumno+"   "+curso); alumno.getCursos().add(curso);
		 * daoAlumnos.save(alumno); return true; } else return false;
		 */

		Optional<Alumno> alumno = daoAlumnos.findById(usuario);
		Optional<Curso> curso = daoCursos.findById(idCurso);

		if (alumno.isPresent() && curso.isPresent()) {
			System.out.println(alumno + "   " + curso);
			alumno.get().getCursos().add(curso.get());
			daoAlumnos.save(alumno.get());
			return true;
		} else
			return false;
	}

	@Override
	public AlumnoDto buscarAlumno(String usuario) {
		return conversor.alumnoToDto( daoAlumnos.findById(usuario).orElse(null));
	}

	@Override
	public CursoDto buscarCurso(int id) {
		return conversor.cursoToDto( daoCursos.findById(id).orElse(null));

	}

	@Override
	public List<AlumnoDto> alumnos() {
		 return daoAlumnos.findAll()
		.stream()
		.map(a->conversor.alumnoToDto(a))
		.collect(Collectors.toList());
	}

	@Override
	public boolean altaAlumno(AlumnoDto a) {
		if (daoAlumnos.findById(a.getUsuario()) != null) {
			daoAlumnos.save(conversor.dtoToAlumno(a));
			return true;
		}
		return false;
	}

	@Override
	public boolean altaCurso(CursoDto c) {
		if (daoCursos.findByNombre(c.getNombre()) != null) {
			daoCursos.save(conversor.dtoToCurso(c));
			return true;
		}
		return false;

	}

	@Override
	public CursoDto buscarCurso(String nombre) {
		Curso c = daoCursos.findByNombre(nombre);
		return conversor.cursoToDto(c);
	}

	@Override
	public List<CursoDto> cursosByRange(Date ini, Date end) {
		return daoCursos.findByFechaInicioBetween(ini, end)
		.stream()
		.map(a->conversor.cursoToDto(a))
		.collect(Collectors.toList());
	}

}
