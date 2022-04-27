package service;

import java.util.List;

import model.Alumno;
import model.Curso;

public interface FormacionService {
	List<Alumno> alumnosCurso(String nombreCurso);
	List<Curso> cursoMatriculadoAlumno(String usuario);
	Alumno validarUsuario(String usuario,String contraseña);
	List<String> cursos();
	List<Alumno> alumnos();
	boolean matricularAlumno(String usuario,int idCurso);
	Alumno buscarAlumno(String usuario);
	Curso buscarCurso(int id);
}
