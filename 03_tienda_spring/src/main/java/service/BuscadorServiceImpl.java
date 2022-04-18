package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import model.Producto;

//Instancia una clase mediante Spring
@Service
public class BuscadorServiceImpl implements BuscadorService {
	
	static ArrayList<Producto> productos=new ArrayList<>(List.of(new Producto("vino","alimentación",8.4,25),
			new Producto("leche","alimentación",1.2,70),
			new Producto("cable usb","informática",5.6,30),
			new Producto("arroz","alimentación",3.1,16),
			new Producto("silla","hogar",30.6,10),
			new Producto("monitor","informática",125.0,5),
			new Producto("escritorio","hogar",230,4)
			));

	public BuscadorServiceImpl() {}
	
	@Override
	public List<Producto> buscar(String seccion) {
		return productos.stream()
				.filter(p -> p.getSeccion().equals(seccion))
				.collect(Collectors.toList());
	}

	@Override
	public void alta(Producto p) {
		productos.add(p);
	}

	@Override
	public void baja(String nombre) {
		for(Producto x : productos) {
			if(x.getNombre().equals(nombre)) {
				productos.remove(x); break;
			}
		}
		
	}

	@Override
	public void modificar(Producto p) {
		int i = 0;
		for(Producto x : productos) {
			if(x.getNombre().equals(p.getNombre())) {
				productos.get(i).setPrecio(p.getPrecio());
			}
			i++;
		}	
	}
	

}
