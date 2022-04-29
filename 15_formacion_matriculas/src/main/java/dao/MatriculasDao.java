package dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Matricula;
import model.MatriculaPk;

public interface MatriculasDao extends JpaRepository<Matricula, MatriculaPk> {
	@Query("select m from Matricula m where m.curso.fechaInicio BETWEEN  ?1 AND ?2")
	List<Matricula> findMatriculaFechas(Date ini, Date end);
}
