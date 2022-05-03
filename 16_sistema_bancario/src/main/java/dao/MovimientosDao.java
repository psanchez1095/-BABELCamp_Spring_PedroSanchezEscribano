package dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Movimiento;


public interface MovimientosDao extends JpaRepository<Movimiento, Integer>{
	
	@Query("SELECT mov FROM Movimiento mov WHERE mov.cuenta.numeroCuenta=?1 AND mov.fecha BETWEEN ?2 AND ?3")
	List<Movimiento> findByMovimientosByRange(int nmCuenta, Date dateIni, Date dateFin);
	
}
