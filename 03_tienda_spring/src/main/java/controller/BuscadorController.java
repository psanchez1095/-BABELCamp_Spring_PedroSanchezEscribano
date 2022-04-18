package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Producto;
import service.BuscadorService;

@Controller
public class BuscadorController {

	// INYECTAMOS CLASE
	@Autowired
	BuscadorService bs;

	@GetMapping(value = "Buscador")
	public String buscar(@RequestParam("seccion") String seccion, HttpServletRequest request) {
		List<Producto> productos = bs.buscar(seccion);
		request.setAttribute("productos", productos);
		// El return le dice a Spring a que vista ir
		return "listado";
	}

	@GetMapping(value = "RouteAddProducto")
	public String routeAddProducto(HttpServletRequest request) {
		return "addPagina";
	}

	@PostMapping(value = "Alta")
	public String añadirProducto(@ModelAttribute Producto product) {
		bs.alta(product);
		return "datos";
	}

	@GetMapping(value = "Eliminar")
	public String eliminarProducto(@RequestParam("nombre") String nombre) {
		bs.baja(nombre);
		return "datos";
	}

	@GetMapping(value = "Modificar")
	public String modificarProducto(@RequestParam("nombre") String nombre, @RequestParam("precio") String precio) {
		bs.modificar(new Producto(nombre, "", Double.parseDouble(precio), -1));
		return "datos";
	}

}
