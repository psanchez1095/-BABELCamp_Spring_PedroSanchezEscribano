package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Cuenta;

public interface CuentasDao extends JpaRepository<Cuenta, Integer> {

	@Query("SELECT c FROM Cuenta c WHERE c.numeroCuenta =?1")
	Cuenta findByNumeroCuenta(int cuenta);

}
