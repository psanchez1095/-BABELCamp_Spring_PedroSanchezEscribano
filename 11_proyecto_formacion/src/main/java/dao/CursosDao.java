package dao;

import java.util.List;


import model.Curso;

public interface CursosDao {
	
	List<Curso> findByAlumno(String usuario);
	List<String> findAll();
	Curso findById(int id);
}
