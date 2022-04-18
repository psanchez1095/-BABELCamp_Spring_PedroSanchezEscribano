package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Pagina;
import service.BuscadorService;

@Controller
public class BuscadorController {

	// INYECTAMOS CLASE
	@Autowired
	BuscadorService bs;

	@GetMapping(value = "Buscador")
	public String buscar(@RequestParam("tema") String tematica, HttpServletRequest request) {
		List<Pagina> paginas = bs.buscar(tematica);
		request.setAttribute("paginas", paginas);
		// El return le dice a Spring a que vista ir
		return "listado";
	}

	@GetMapping(value = "RouteAddPagina")
	public String routePagina(HttpServletRequest request) {
		return "addPagina";
	}

	/*@PostMapping(value = "AddPagina")
	public String añadirPagina(@RequestParam("tematica") String tematica,
			@RequestParam("url") String url,
			@RequestParam("desc") String desc) {
		bs.alta(new Pagina(url, tematica, desc));
		return "datos";
	}*/
	
	@PostMapping(value = "AddPagina")
	public String añadirPagina(@ModelAttribute Pagina pagina) {
		bs.alta(pagina);
		return "datos";
	}

}
