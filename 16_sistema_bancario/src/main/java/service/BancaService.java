package service;

import java.util.Date;
import java.util.List;
import dtos.CuentaDto;
import dtos.MovimientoDto;


public interface BancaService {
	
   CuentaDto validateAccount(int numeroCuenta);
   List<MovimientoDto> consultMovements(Date start, Date end,int numeroCuenta);
   boolean depositSaldo(int numeroCuenta, int cantidad);
   boolean drawSaldo(int numeroCuenta, int cantidad);
   boolean transferSaldo(int numeroCuenta, int toNumeroCuenta, int cantidad);

}
