package service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import converters.ConversorEntityDto;
import dao.ClientesDao;
import dao.CuentasDao;
import dao.MovimientosDao;
import dtos.CuentaDto;
import dtos.MovimientoDto;
import model.Cuenta;
import model.Movimiento;


@Service
public class BancaServiceImp implements BancaService {

	@Autowired
	ConversorEntityDto conversor;
	CuentasDao daoCuentas;
	ClientesDao daoClientes;
	MovimientosDao daoMovimientos;

	public BancaServiceImp(@Autowired CuentasDao daoCuentas, @Autowired ClientesDao daoClientes,
			@Autowired MovimientosDao daoMovimientos) {
		super();
		this.daoCuentas = daoCuentas;
		this.daoClientes = daoClientes;
		this.daoMovimientos = daoMovimientos;
	}

	@Override
	public CuentaDto validateAccount(int numeroCuenta) {
		Cuenta c = daoCuentas.findByNumeroCuenta(numeroCuenta);
		if ( c!= null)return conversor.cuentaToDto(daoCuentas.findByNumeroCuenta(numeroCuenta));
		else return null;
	}

	@Override
	public List<MovimientoDto> consultMovements(Date start, Date end, int numeroCuenta) {
		return daoMovimientos.findByCuentaNumeroCuentaAndFechaBetween(numeroCuenta, start, end).stream().map(mov->conversor.movimientoToDto(mov)).collect(Collectors.toList());
	}

	@Override
	public boolean depositSaldo(int numeroCuenta, int cantidad) {

		Optional<Cuenta> cuenta = daoCuentas.findById(numeroCuenta);

		if (cuenta.isPresent()) {

			Movimiento m = new Movimiento(numeroCuenta, new Date(), cantidad, "Deposit");
			daoMovimientos.save(m);
			cuenta.get().setSaldo(cuenta.get().getSaldo() + cantidad);
			daoCuentas.save(cuenta.get());

			return true;

		}
		return false;
	}

	@Override
	public boolean drawSaldo(int numeroCuenta, int cantidad) {

		Optional<Cuenta> cuenta = daoCuentas.findById(numeroCuenta);

		if (cuenta.isPresent()) {

			Movimiento m = new Movimiento(numeroCuenta, new Date(), cantidad, "Draw");
			daoMovimientos.save(m);
			cuenta.get().setSaldo(cuenta.get().getSaldo() - cantidad);
			daoCuentas.save(cuenta.get());

			return true;
		}
		return false;
	}

	@Override
	public boolean transferSaldo(int numeroCuentaOrigen, int numeroCuentaDest, int cantidad) {

		Optional<Cuenta> cuentaOrigen = daoCuentas.findById(numeroCuentaOrigen);
		Optional<Cuenta> cuentaDest = daoCuentas.findById(numeroCuentaDest);

		if (cuentaOrigen.isPresent() && cuentaDest.isPresent()) {

			Movimiento m = new Movimiento(numeroCuentaOrigen, new Date(), cantidad, "Transfer");
			daoMovimientos.save(m);

			cuentaOrigen.get().setSaldo(cuentaOrigen.get().getSaldo() - cantidad);
			cuentaDest.get().setSaldo(cuentaDest.get().getSaldo() + cantidad);
			daoCuentas.save(cuentaOrigen.get());
			daoCuentas.save(cuentaDest.get());

			return true;
		}
		return false;
	}

}
