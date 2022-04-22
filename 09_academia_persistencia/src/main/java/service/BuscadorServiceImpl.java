package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Alumno;


//Instancia una clase mediante Spring
@Service
public class BuscadorServiceImpl implements BuscadorService {
	
	@PersistenceContext
	EntityManager entityManager;

	public BuscadorServiceImpl() {
	}
	
	@Override
	@Transactional
	public List<Alumno> buscarPorCurso(String curso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Alumno buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void alta(Alumno p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void baja(String nombreAlumno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void modificar(Alumno p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public boolean existeAlumno(String nombreAlumno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional
	public List<String> cursos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Alumno> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
