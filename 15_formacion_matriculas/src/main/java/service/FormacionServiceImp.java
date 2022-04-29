package service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import converters.ConversorEntityDto;
import dao.AlumnosDao;
import dao.CursosDao;
import dao.MatriculasDao;
import dtos.AlumnoDto;
import dtos.CursoDto;
import dtos.MatriculaDto;
import model.Alumno;
import model.Curso;
import model.Matricula;
import model.MatriculaPk;

@Service
public class FormacionServiceImp implements FormacionService {

	@Autowired
	ConversorEntityDto conversor;
	CursosDao daoCursos;
	AlumnosDao daoAlumnos;
	MatriculasDao daoMatriculas;

	public FormacionServiceImp(@Autowired CursosDao daoCursos, @Autowired AlumnosDao daoAlumnos,
			@Autowired MatriculasDao daoMatriculas) {
		super();
		this.daoCursos = daoCursos;
		this.daoAlumnos = daoAlumnos;
		this.daoMatriculas = daoMatriculas;
	}

	@Override
	public List<CursoDto> cursos() {
		return daoCursos.findAll().stream().map(a -> conversor.cursoToDto(a)).collect(Collectors.toList());
	}

	@Override
	public List<AlumnoDto> alumnosCurso(String nombreCurso) {
		return daoAlumnos.findByCurso(nombreCurso).stream().map(a -> conversor.alumnoToDto(a))
				.collect(Collectors.toList());

	}

	@Override
	public List<CursoDto> cursoMatriculadoAlumno(String usuario) {
		return daoCursos.findByAlumno(usuario).stream().map(a -> conversor.cursoToDto(a)).collect(Collectors.toList());
	}

	@Override
	public List<CursoDto> cursoNoMatriculadoAlumno(String usuario) {
		return daoCursos.findByAlumnoNoMatriculado(usuario).stream().map(a -> conversor.cursoToDto(a))
				.collect(Collectors.toList());
	}

	@Override
	public AlumnoDto validarUsuario(String usuario, String contraseña) {
		return conversor.alumnoToDto(daoAlumnos.findByUsuarioAndPassword(usuario, contraseña));
	}

	@Override
	@Transactional
	public boolean matricularAlumno(String usuario, int idCurso) {

		Optional<Alumno> alumno = daoAlumnos.findById(usuario);
		Optional<Curso> curso = daoCursos.findById(idCurso);

		if (alumno.isPresent() && curso.isPresent()) {
			daoMatriculas.save(new Matricula(new MatriculaPk(idCurso, usuario), 0, curso.get(), alumno.get()));
			return true;
		} else
			return false;
	}

	@Override
	public AlumnoDto buscarAlumno(String usuario) {
		return conversor.alumnoToDto(daoAlumnos.findById(usuario).orElse(null));
	}

	@Override
	public CursoDto buscarCurso(int id) {
		return conversor.cursoToDto(daoCursos.findById(id).orElse(null));

	}

	@Override
	public List<AlumnoDto> alumnos() {
		return daoAlumnos.findAll().stream().map(a -> conversor.alumnoToDto(a)).collect(Collectors.toList());
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
	public List<MatriculaDto> matriculasByRange(Date ini, Date end) {
		return daoMatriculas.findMatriculaFechas(ini, end)
				.stream()
				.map(a -> conversor.matriculaToDto(a))
				.collect(Collectors.toList());
	}

}
