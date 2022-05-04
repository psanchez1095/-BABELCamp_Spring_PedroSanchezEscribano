package testing;

import static org.junit.jupiter.api.Assertions.assertNotEquals;



import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.ServiceConfig;
import service.BancaService;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ServiceConfig.class} )
public class TestBancaService {
	@Autowired 
	BancaService service;
	
@Test void testValidaraCuenta() {
		
		assertNotEquals(null,service.validateAccount(100));
	}
	
}
