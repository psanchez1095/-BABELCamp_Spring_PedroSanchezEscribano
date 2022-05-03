package dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Cuenta;

public interface CuentasDao extends JpaRepository<Cuenta, Integer> {

	@Query("select c from Cuenta c where c.numeroCuenta =?1")
	Cuenta findByNumeroCuenta(int cuenta);

}
