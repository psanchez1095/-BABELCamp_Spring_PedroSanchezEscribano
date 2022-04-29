package service;

import java.util.Date;
import java.util.List;

import model.Alumno;
import model.Curso;

public interface FormacionService {
	List<Alumno> alumnosCurso(String nombreCurso);
	List<Curso> cursoMatriculadoAlumno(String usuario);
	
	Alumno validarUsuario(String usuario,String contraseña);
	List<Curso> cursos();
	List<Alumno> alumnos();
	boolean matricularAlumno(String usuario,int idCurso);
	Alumno buscarAlumno(String usuario);
	Curso buscarCurso(int id);
	//NUEVO
	Curso buscarCurso(String nombre);
	boolean altaAlumno(Alumno a);
	boolean altaCurso(Curso a);
	List<Curso> cursosByRange(Date ini,Date end);
	List<Curso> cursoNoMatriculadoAlumno(String usuario);
	
}
