package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import model.Pagina;

//Instancia una clase mediante Spring
@Service
public class BuscadorServiceImpl implements BuscadorService {
	
	static ArrayList<Pagina> paginas=new ArrayList<>();
	public BuscadorServiceImpl() {
		paginas.add(new Pagina("http://www.fnac.es","libros","Libros y m�s cosas"));
		paginas.add(new Pagina("http://www.gamer.es","juegos","Juegos on-line"));
		paginas.add(new Pagina("http://www.casadellibro.es","libros","La Web de los libros"));
		paginas.add(new Pagina("http://www.mydisc.es","musica","M�sica de todo tipo"));
		paginas.add(new Pagina("http://www.radio.es","musica","M�sica de actualidad"));
	}
	
	@Override
	public List<Pagina> buscar(String tematica) {
		return paginas.stream()
				.filter(p -> p.getTematica().equals(tematica))
				.collect(Collectors.toList());
	}

	@Override
	public void alta(Pagina p) {
		paginas.add(p);
		
	}

}
