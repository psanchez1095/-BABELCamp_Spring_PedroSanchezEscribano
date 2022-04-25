package testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.ServiceConfig;
import service.ProductosService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ServiceConfig.class} )

public class TestProductosService {
	
	@Autowired 
	ProductosService service;
	
	@Test void testProducto() {
	
		assertEquals(22.0,service.buscar(3).getPrecio());
	}
	
	@Test void testMedia() {
		assertEquals(150.0,service.precioMedioSeccion("decoracion"));
	}
	
	
	
}
