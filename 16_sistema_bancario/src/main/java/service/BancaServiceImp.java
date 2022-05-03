package service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.ClientesDao;
import dao.CuentasDao;
import dao.TitularesDao;
import dtos.ClienteDto;
import dtos.CuentaDto;
import dtos.TitularDto;
import model.Cliente;
import model.Cuenta;
import model.Titular;
import model.TitularPk;

@Service
public class BancaServiceImp implements BancaService {

	@Autowired
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
	public List<ClienteDto> alumnosCurso(String nombreCurso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CuentaDto> cursoMatriculadoAlumno(String usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClienteDto validarUsuario(String usuario, String contraseña) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CuentaDto> cursos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClienteDto> alumnos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean añadirTitular(int idCuenta, int idCliente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ClienteDto buscarAlumno(String usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CuentaDto buscarCurso(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CuentaDto buscarCurso(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean altaAlumno(ClienteDto a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean altaCurso(CuentaDto a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<TitularDto> matriculasByRange(Date ini, Date end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CuentaDto> cursoNoMatriculadoAlumno(String usuario) {
		// TODO Auto-generated method stub
		return null;
	}



}
