package service;

import java.util.List;

import model.Alumno;
import model.Curso;

public interface EscuelaService {
	List<Alumno> alumnosCurso(String nombre);
	List<Alumno> alumnosCursoDuracion(int duracionMax);
	List<Curso> alumnosSenior(int edad);
	Curso cursoMatriculadoAlumno(String alumno);
	double edadMediaCurso(String nombreCurso);
	double precioCurso(String email);
}
