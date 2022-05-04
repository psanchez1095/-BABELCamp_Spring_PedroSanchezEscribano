package dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MovimientoDto {

	private int idMovimiento;
	private int idCuenta;
	private CuentaDto cuentaDto;
	@JsonFormat(pattern ="yyyy-MM-dd")
	private Date fecha;
	private int cantidad;
	private String operacion;
	
}
