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

import model.Producto;
import service.BuscadorService;

//Para no bloquear el acceso de otra direcciones
@CrossOrigin("*")
@Controller
public class ProductController {

	// INYECTAMOS CLASE
	@Autowired
	BuscadorService bs;
	
	//La notación body indica que el return se mete en el cuerpo de la respuesta
	//Con la propiedad produces indicas que el cuerpo se formatea a json
	@GetMapping(value = "Buscador",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Producto> buscar(@RequestParam("seccion") String seccion, HttpServletRequest request) {
		return bs.buscarPorSeccion(seccion);		
	}
	
	@GetMapping(value = "BuscadorId")
	public String buscarPorId(@RequestParam("id") String id, HttpServletRequest request) {
		List<Producto> productos = new ArrayList<Producto>();
		Producto producto= bs.buscar(Integer.parseInt(id));
		productos.add(producto);
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
		Producto aux = bs.buscarPorNombre(nombre);
		if(aux!=null) aux.setPrecio(Double.parseDouble(precio));
		bs.modificar(aux);
		return "datos";
	}

}
