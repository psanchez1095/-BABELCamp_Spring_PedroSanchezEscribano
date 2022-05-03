package converters;

import org.springframework.stereotype.Component;

import dtos.ClienteDto;
import dtos.CuentaDto;
import dtos.MovimientoDto;
import dtos.TitularDto;
import model.Cliente;
import model.Cuenta;
import model.Movimiento;
import model.Titular;

@Component
public class ConversorEntityDtoImp implements ConversorEntityDto {

	@Override
	public CuentaDto cuentaToDto(Cuenta cuenta) {
		return new CuentaDto(cuenta.getNumeroCuenta(),cuenta.getSaldo(),cuenta.getTipocuenta());
	}

	@Override
	public Cuenta dtoToCuenta(CuentaDto dto) {
		return new Cuenta(dto.getNumeroCuenta(),dto.getSaldo(),dto.getTipocuenta());
	}

	@Override
	public ClienteDto clienteToDto(Cliente alumno) {
		return new ClienteDto(alumno.getDni(),alumno.getNombre(),alumno.getDireccion(),alumno.getTelefono());
	}

	@Override
	public Cliente dtoToCliente(ClienteDto dto) {
		return new Cliente(dto.getDni(),dto.getNombre(),dto.getDireccion(),dto.getTelefono());
	}

	@Override
	public TitularDto titularToDto(Titular titular) {
		return new TitularDto(cuentaToDto(titular.getCuenta()),clienteToDto(titular.getCliente()));
	}

	@Override
	public Titular dtoToTitular(TitularDto dto) {
		return new Titular(dtoToCuenta(dto.getCuentaDto()),dtoToCliente(dto.getAlumnoDto()));
	}

	@Override
	public MovimientoDto movimientoToDto(Movimiento movimiento) {
		return new MovimientoDto(movimiento.getIdMovimiento(),cuentaToDto(movimiento.getCuenta()),movimiento.getFecha(),movimiento.getCantidad(),movimiento.getOperacion());
	}

	@Override
	public Movimiento dtoToMovimiento(MovimientoDto dto) {
		return new Movimiento(dto.getIdMovimiento(),dto.getFecha(),dto.getCantidad(),dto.getOperacion(),dtoToCuenta(dto.getCuentaDto()));
	}

	
}
