package dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Curso;

public interface CursosDao extends JpaRepository<Curso, Integer> {

	@Query("select c from Curso c join c.alumnos a where a.usuario =?1")
	List<Curso> findByAlumno(String usuario);

	@Query("Select c From Curso c Where c Not In (Select c From Curso c join c.alumnos a Where a.usuario=?1)")

	List<Curso> findByAlumnoNoMatriculado(String usuario);

	@Query("select c from Curso c where c.fechaInicio BETWEEN ?1 AND ?2")
	List<Curso> findByFechaInicioBetween(Date ini, Date end);

	@Query("select c from Curso c where c.nombre =?1")
	Curso findByNombre(String nombre);

}
