package service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import converters.ConversorEntityDto;
import dao.ClientesDao;
import dao.CuentasDao;
import dao.TitularesDao;
import dtos.ClienteDto;
import dtos.CuentaDto;
import dtos.MovimientoDto;
import dtos.TitularDto;
import model.Cliente;
import model.Cuenta;
import model.Titular;
import model.TitularPk;

@Service
public class BancaServiceImp implements BancaService {

	@Autowired (required=true)
	ConversorEntityDto conversor;
	CuentasDao daoCuentas;
	ClientesDao daoClientes;
	TitularesDao daoMatriculas;

	public BancaServiceImp(@Autowired CuentasDao daoCuentas, @Autowired ClientesDao daoClientes,
			@Autowired TitularesDao daoMatriculas) {
		super();
		this.daoCuentas = daoCuentas;
		this.daoClientes = daoClientes;
		this.daoMatriculas = daoMatriculas;
	}

	@Override
	public CuentaDto validarCuenta(int numeroCuenta) {
		return conversor.cuentaToDto(daoCuentas.findByNumeroCuenta(numeroCuenta));
	}

	@Override
	public boolean ingresar(int numeroCuenta, int cantidad) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean extraccion(int numeroCuenta, int cantidad) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean transferencia(int numeroCuenta, int toNumeroCuenta, int cantidad) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<MovimientoDto> consultarMovimientos(Date start, Date end) {
		// TODO Auto-generated method stub
		return null;
	}



}
