package controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dtos.MovimientoDto;
import service.BancaService;

@CrossOrigin("*")
@Controller
public class BancaController {

	// INYECTAMOS CLASE
	@Autowired
	BancaService bancaService;

	@PostMapping(value = "Validate")
	public String validarUsuario(@RequestParam("numeroCuenta") int numCuenta) {
		bancaService.validateAccount(numCuenta);
		return "menu";
	}
	
	@PostMapping(value="Deposit")
	public String ingresar(@RequestParam("numeroCuenta")int numeroCuenta, @RequestParam("cantidad")int cantidad) {
		
		if(bancaService.depositSaldo(numeroCuenta,cantidad)) {
			return "menu";
			}
		else {
			return "error";
		}
	}
	
	@PostMapping(value="Draw")
	public String extraccion(@RequestParam("numeroCuenta")int numeroCuenta, @RequestParam("cantidad")int cantidad) {
		
		if(bancaService.drawSaldo(numeroCuenta,cantidad)) {
			return "menu";
			}
		else {
			return "error";
		}
	}
	
	@PostMapping(value="Transfer")
	public String extraccion(@RequestParam("numeroCuentaOrigen")int numeroCuentaOrigen, @RequestParam("numeroCuentaDest")int numeroCuentaDest, @RequestParam("cantidad")int cantidad) {
		
		if(bancaService.transferSaldo(numeroCuentaOrigen,numeroCuentaDest,cantidad)) {
			return "menu";
			}
		else {
			return "error";
		}
	}
	
	
	@GetMapping(value = "ConsultaMovimientos", produces = MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody List<MovimientoDto> movimientos(@RequestParam("numeroCuenta")int numeroCuenta, @DateTimeFormat(pattern ="yyyy-MM-dd") @RequestParam("dateIni") Date dateIni,
			@DateTimeFormat(pattern ="yyyy-MM-dd") @RequestParam("dateEnd") Date dateEnd) {
		
		return bancaService.consultMovements(dateIni, dateEnd,numeroCuenta);
	}


	
}
