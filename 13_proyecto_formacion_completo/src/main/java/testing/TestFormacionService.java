package testing;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.ServiceConfig;
import model.Curso;
import model.Alumno;
import service.FormacionService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ServiceConfig.class} )
public class TestFormacionService {
	@Autowired 
	FormacionService service;
	
	@Test void testValidaraAlumno() {
		
		assertNotEquals(null,service.validarUsuario("admin", "a"));
	}
	
	@Test void testCursoMatriculadoAlumno() {
		assertEquals(2,service.cursoMatriculadoAlumno("aaa").size());
	}
	@Test void testCursoNoMatriculadoAlumno() {
		assertEquals(12,service.cursoNoMatriculadoAlumno("webmvc").size());
	}
	
	@Test void testListaCursos() {
		assertNotEquals(null,service.cursos());
	}
	
	@Test void testAltaAlumno() {
		assertNotEquals(null,service.altaAlumno(new Alumno("xer","der","ere","sdda",33)));
	}
	@Test void testAltaCurso() {
		Calendar c1 = Calendar.getInstance();
		c1.set(2022, 5,14);
		assertNotEquals(null,service.altaCurso(new Curso(19,"xerse",22,22.11,c1.getTime())));
	}
	@Test void testCursoByRange() {
		Calendar c1 = Calendar.getInstance();
		c1.set(2022, 4,14);
		Calendar c2 = Calendar.getInstance();
		c1.set(2022, 8,14);
		assertEquals(1,service.cursosByRange(c1.getTime(), c2.getTime()).size());
	}
	
}
