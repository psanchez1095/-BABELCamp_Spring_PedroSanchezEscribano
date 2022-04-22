package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
		
		TypedQuery<Alumno> query;
		query = entityManager.createNamedQuery("Alumno.findByCurso", Alumno.class);
		query.setParameter("curso", curso);
		
		List<Alumno> resultList = query.getResultList();
		
		
		 return resultList;
	}

	@Override
	@Transactional
	public Alumno buscar(int id) {
		return entityManager.find(Alumno.class, id);
	}

	@Override
	@Transactional
	public void alta(Alumno p) {
		entityManager.persist(p);
		
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
		if(buscarPorNombre(nombreAlumno)!=null) return true;
		else return false;
	}

	@Override
	@Transactional
	public List<String> cursos() {
		TypedQuery<String> query;
		query = entityManager.createNamedQuery("Alumno.findCursos", String.class);
		return query.getResultList();
		
	}

	@Override
	@Transactional
	public List<Alumno> buscarPorNombre(String nombre) {
		
		TypedQuery<Alumno> query;
		query = entityManager.createNamedQuery("Alumno.findByNombre", Alumno.class);
		query.setParameter("nombre", nombre);
		
		List<Alumno> resultList = query.getResultList();
		
		
		 return resultList;
	}

	

}
