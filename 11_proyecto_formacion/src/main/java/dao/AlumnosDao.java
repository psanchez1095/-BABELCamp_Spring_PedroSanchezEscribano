package dao;

import java.util.List;

import model.Alumno;

public interface AlumnosDao {
	List<Alumno> findByCurso(String nombreCurso);
	Alumno findByUsuarioAndPassword(String usuario,String contrase�a);
	Alumno findById(String usuario);
	void update(Alumno alumno);
	List<Alumno> findAll();
	
}
