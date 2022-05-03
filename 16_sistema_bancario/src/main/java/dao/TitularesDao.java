package dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Titular;
import model.TitularPk;

public interface TitularesDao extends JpaRepository<Titular, TitularPk> {
	
}
