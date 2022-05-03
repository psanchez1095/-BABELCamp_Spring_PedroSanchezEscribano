package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dtos.ClienteDto;
import dtos.CuentaDto;
import dtos.TitularDto;
import model.Cliente;
import service.BancaService;

@CrossOrigin("*")
@Controller
public class BancaController {

	// INYECTAMOS CLASE
	@Autowired
	BancaService fs;

	@PostMapping(value = "Validar")
	public String validarUsuario(@RequestParam("numeroCuenta") int numCuenta) {
		fs.validarCuenta(numCuenta);
		return "menu";
	}


	
}
