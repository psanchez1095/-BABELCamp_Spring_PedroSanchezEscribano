package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Producto;

//Instancia una clase mediante Spring
@Service
public class BuscadorServiceImpl implements BuscadorService {
	//Inyecta Entity Manager
	@PersistenceContext
	EntityManager entityManager;
	@Override
	public List<Producto> buscar(String seccion) {
		
		// TODO Auto-generated method stub
		
		TypedQuery<Producto> query;
		query = entityManager.createNamedQuery("Producto.findBySeccion", Producto.class);
		query.setParameter("seccion", seccion);
		
		List<Producto> resultList = query.getResultList();
		
		
		
		 return resultList;

	}

	@Override
	public Producto buscar(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Producto.class, id);
	}
	
	@Transactional
	@Override
	public void alta(Producto p) {
		entityManager.persist(p);
		
	}

	@Override
	public void baja(String nombreProducto) {
		
		
	}

	@Override
	public void modificar(Producto p) {
		// TODO Auto-generated method stub
		
	}
	
	


}
