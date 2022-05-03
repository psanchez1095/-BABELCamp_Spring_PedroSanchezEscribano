package dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Curso;

public interface CursosDao extends JpaRepository<Curso, Integer> {

	@Query("select c from Curso c join c.matriculas m where m.alumno.usuario =?1")
	List<Curso> findByAlumno(String usuario);

	@Query("Select c From Curso c Where c Not In (Select c From Curso c join c.matriculas m where m.alumno.usuario =?1)")
	List<Curso> findByAlumnoNoMatriculado(String usuario);

	@Query("select c from Curso c where c.nombre =?1")
	Curso findByNombre(String nombre);

}
