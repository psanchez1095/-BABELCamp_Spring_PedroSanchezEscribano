package converters;

import org.springframework.stereotype.Component;

import dtos.ClienteDto;
import dtos.CuentaDto;
import dtos.TitularDto;
import model.Cliente;
import model.Cuenta;
import model.Titular;

@Component
public class ConversorEntityDtoImp implements ConversorEntityDto {

	@Override
	public CuentaDto cuentaToDto(Cuenta cuenta) {
		return new CuentaDto(cuenta.getNumeroCuenta(),cuenta.getSaldo(),cuenta.getTipocuenta());
	}

	@Override
	public Cuenta dtoToCuenta(CuentaDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClienteDto clienteToDto(Cliente alumno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente dtoToCliente(ClienteDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TitularDto titularToDto(Titular matricula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Titular dtoToTitular(TitularDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
