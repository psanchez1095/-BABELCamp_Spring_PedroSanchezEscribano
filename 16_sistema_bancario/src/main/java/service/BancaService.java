package service;

import java.util.Date;
import java.util.List;

import dtos.ClienteDto;
import dtos.CuentaDto;
import dtos.MovimientoDto;
import dtos.TitularDto;

public interface BancaService {
	
   CuentaDto validarCuenta(int numeroCuenta);
   
   List<MovimientoDto> consultarMovimientos(Date start, Date end);

   boolean depositSaldo(int numeroCuenta, int cantidad);

   boolean drawSaldo(int numeroCuenta, int cantidad);

   boolean transferSaldo(int numeroCuenta, int toNumeroCuenta, int cantidad);

}
