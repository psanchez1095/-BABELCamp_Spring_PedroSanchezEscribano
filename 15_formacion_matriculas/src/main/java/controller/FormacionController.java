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

import dtos.AlumnoDto;
import dtos.CursoDto;
import dtos.MatriculaDto;
import service.FormacionService;

@CrossOrigin("*")
@Controller
public class FormacionController {

	// INYECTAMOS CLASE
	@Autowired
	FormacionService fs;

	@GetMapping(value = "BuscadorAlumnosCurso", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<AlumnoDto> buscarAlumnosCurso(@RequestParam("nombreCurso") String nombreCurso,
			HttpServletRequest request) {
		return fs.alumnosCurso(nombreCurso);
	}

	@GetMapping(value = "BuscadorCursosAlumno", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CursoDto> buscarCursosAlumno(@RequestParam("usuario") String usuario,
			HttpServletRequest request) {
		return fs.cursoMatriculadoAlumno(usuario);
	}

	@PostMapping(value = "Validar")
	public String validarUsuario(@RequestParam("usuario") String usuario, @RequestParam("password") String password) {
		fs.validarUsuario(usuario, password);
		return "menu";
	}

	@GetMapping(value = "BuscarCursos", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CursoDto> buscarCursos(HttpServletRequest request) {
		List<CursoDto> list = fs.cursos();
		return list;
	}

	@GetMapping(value = "BuscarAlumnos", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<AlumnoDto> buscarAlumnos(HttpServletRequest request) {
		List<AlumnoDto> list = fs.alumnos();
		return list;
	}

	// NUEVO
	@GetMapping(value = "BuscadorCursosNoAlumno", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CursoDto> buscarCursosNoAlumno(@RequestParam("usuario") String usuario,
			HttpServletRequest request) {
		return fs.cursoNoMatriculadoAlumno(usuario);
	}

	// NUEVO
	@PostMapping(value = "AltaAlumno")
	public String añadirAlumno(@ModelAttribute AlumnoDto a) {
		boolean ok = fs.altaAlumno(a);
		if (ok)
			return "menu";
		else
			return "error";
	}

	// NUEVO
	@PostMapping(value = "AltaCurso")
	public String añadirCurso(@RequestParam("nombre") String nombre, @RequestParam("duracion") int duracion, @RequestParam("precio") double precio, @RequestParam("fechaInicio") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio) {
		boolean ok = fs.altaCurso(new CursoDto(nombre,duracion,precio,fechaInicio));
		if (ok)
			return "menu";
		else
			return "error";
	}

	// NUEVO
	@GetMapping(value = "BuscadorMatriculasByRange", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<MatriculaDto> buscarCursosRangeFechas(
			@RequestParam("fechaIni") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaIni,
			@RequestParam("fechaFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin,
			HttpServletRequest request) {
		System.out.println(fechaIni);
		return fs.matriculasByRange(fechaIni, fechaFin);

	}

	@PostMapping(value = "Matricular")
	public String matricular(@RequestParam("idCurso") int idCurso, @RequestParam("usuario") String usuario) {
		fs.matricularAlumno(usuario, idCurso);
		return "index";
	}
	@GetMapping(value = "routeAltaAlumno")
	public String routeAltaAlumno(
			HttpServletRequest request) {
		return "altaAlumno";
	}
	@GetMapping(value = "routeAltaCurso")
	public String routeAltaCurso(
			HttpServletRequest request) {
		return "altaCurso";
	}

	
}
