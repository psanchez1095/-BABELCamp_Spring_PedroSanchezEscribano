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

	@GetMapping(value = "BuscadorAlumnosCurso", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ClienteDto> buscarAlumnosCurso(@RequestParam("nombreCurso") String nombreCurso,
			HttpServletRequest request) {
		return fs.alumnosCurso(nombreCurso);
	}

	@GetMapping(value = "BuscadorCursosAlumno", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CuentaDto> buscarCursosAlumno(@RequestParam("usuario") String usuario,
			HttpServletRequest request) {
		return fs.cursoMatriculadoAlumno(usuario);
	}

	@PostMapping(value = "Validar")
	public String validarUsuario(@RequestParam("usuario") String usuario, @RequestParam("password") String password) {
		fs.validarUsuario(usuario, password);
		return "menu";
	}

	@GetMapping(value = "BuscarCursos", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CuentaDto> buscarCursos(HttpServletRequest request) {
		List<CuentaDto> list = fs.cursos();
		return list;
	}

	@GetMapping(value = "BuscarAlumnos", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ClienteDto> buscarAlumnos(HttpServletRequest request) {
		List<ClienteDto> list = fs.alumnos();
		return list;
	}

	// NUEVO
	@GetMapping(value = "BuscadorCursosNoAlumno", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CuentaDto> buscarCursosNoAlumno(@RequestParam("usuario") String usuario,
			HttpServletRequest request) {
		return fs.cursoNoMatriculadoAlumno(usuario);
	}

	// NUEVO
	@PostMapping(value = "AltaAlumno")
	public String añadirAlumno(@ModelAttribute ClienteDto a) {
		boolean ok = fs.altaAlumno(a);
		if (ok)
			return "menu";
		else
			return "error";
	}

	// NUEVO
	@PostMapping(value = "AltaCurso")
	public String añadirCurso(@ModelAttribute CuentaDto c) {
		boolean ok = fs.altaCurso(c);
		if (ok)
			return "menu";
		else
			return "error";
	}

	// NUEVO
	@GetMapping(value = "BuscadorMatriculasByRange", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<TitularDto> buscarCursosRangeFechas(
			@RequestParam("fechaIni") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaIni,
			@RequestParam("fechaFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin,
			HttpServletRequest request) {
		return fs.matriculasByRange(fechaIni, fechaFin);

	}

	@PostMapping(value = "Matricular")
	public String matricular(@RequestParam("idCliente") int idCliente, @RequestParam("idCuenta") int idCuenta) {
		fs.añadirTitular(idCliente, idCuenta);
		return "index";
	}
}
