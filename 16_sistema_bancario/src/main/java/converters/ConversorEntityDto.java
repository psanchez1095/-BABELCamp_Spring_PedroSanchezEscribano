package converters;


import dtos.ClienteDto;
import dtos.CuentaDto;
import dtos.TitularDto;
import model.Cliente;
import model.Cuenta;
import model.Titular;


public interface ConversorEntityDto {
	public CuentaDto cuentaToDto(Cuenta cuenta);
	public Cuenta dtoToCuenta(CuentaDto dto);
	public ClienteDto clienteToDto(Cliente alumno);
	public Cliente dtoToCliente(ClienteDto dto);
	public TitularDto titularToDto(Titular matricula);
	public Titular dtoToTitular(TitularDto dto);
}
