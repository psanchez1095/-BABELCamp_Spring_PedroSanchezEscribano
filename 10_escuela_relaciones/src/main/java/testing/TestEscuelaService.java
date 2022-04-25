package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.ServiceConfig;
import service.EscuelaService;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ServiceConfig.class} )
public class TestEscuelaService {
	
	@Autowired 
	EscuelaService service;
	
	@Test void testAlumnosCurso() {
	
		assertNotEquals(null,service.alumnosCurso("python"));
	}
	@Test void testAlumnosCursoDuracion() {
		assertEquals(3,service.alumnosCursoDuracion(80).size());
	}
	@Test void testPrecioCurso() {
		assertEquals(250,service.precioCurso("primero@gmail.com"));
	}
	
	@Test void testCursoMatriculadoAlumno() {
		assertNotEquals(null,service.cursoMatriculadoAlumno("1111A"));
	}
	
}
