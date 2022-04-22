package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Alumno;
import service.BuscadorService;

@CrossOrigin("*")
@Controller
public class AlumnoController {

	// INYECTAMOS CLASE
	@Autowired
	BuscadorService bs;

	@GetMapping(value = "Buscador",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Alumno> buscar(@RequestParam("curso") String curso, HttpServletRequest request) {
		return bs.buscarPorCurso(curso);		
	}
	
	@GetMapping(value = "BuscadorId")
	public String buscarPorId(@RequestParam("id") String id, HttpServletRequest request) {
		List<Alumno> alumnos = new ArrayList();
		Alumno alumno= bs.buscar(Integer.parseInt(id));
		alumnos.add(alumno);
		request.setAttribute("productos", alumnos);
		// El return le dice a Spring a que vista ir
		return "listado";
	}

	@PostMapping(value = "Alta")
	public String añadirAlumno(@ModelAttribute Alumno product) {
		bs.alta(product);
		return "inicio";
	}

	@GetMapping(value = "Eliminar")
	public String eliminarAlumno(@RequestParam("nombre") String nombre) {
		bs.baja(nombre);
		return "datos";
	}

	@GetMapping(value = "Modificar")
	public String modificarAlumno(@RequestParam("nombre") String nombre, @RequestParam("precio") String precio) {
		bs.modificar(new Alumno(-1,nombre, "", Integer.parseInt(precio)));
		return "datos";
	}
	
	@GetMapping(value = "BuscarCursos",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<String> buscarCursos(HttpServletRequest request) {
		List<String> list = bs.cursos();
		return list;
	}

}
