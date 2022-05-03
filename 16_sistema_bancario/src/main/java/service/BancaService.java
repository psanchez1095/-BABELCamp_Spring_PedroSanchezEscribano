package service;

import java.util.Date;
import java.util.List;

import dtos.ClienteDto;
import dtos.CuentaDto;
import dtos.TitularDto;

public interface BancaService {
	List<ClienteDto> alumnosCurso(String nombreCurso);
	List<CuentaDto> cursoMatriculadoAlumno(String usuario);
	
	ClienteDto validarUsuario(String usuario,String contraseña);
	List<CuentaDto> cursos();
	List<ClienteDto> alumnos();
	boolean añadirTitular(int idCuenta, int idCliente);
	ClienteDto buscarAlumno(String usuario);
	CuentaDto buscarCurso(int id);
	//NUEVO
	CuentaDto buscarCurso(String nombre);
	boolean altaAlumno(ClienteDto a);
	boolean altaCurso(CuentaDto a);
	List<TitularDto> matriculasByRange(Date ini,Date end);
	List<CuentaDto> cursoNoMatriculadoAlumno(String usuario);
	
}
