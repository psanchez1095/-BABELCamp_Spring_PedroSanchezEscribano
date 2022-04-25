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
public class ProductosServiceImpl implements ProductosService {
	//Inyecta Entity Manager
	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	@Override
	public List<Producto> buscarPorSeccion(String seccion) {
		
		// TODO Auto-generated method stub
		
		TypedQuery<Producto> query;
		query = entityManager.createNamedQuery("Producto.findBySeccion", Producto.class);
		query.setParameter("seccion", seccion);
		
		List<Producto> resultList = query.getResultList();
		
		
		 return resultList;

	}

	@Transactional
	@Override
	public Producto buscarPorNombre(String nombre) {

		TypedQuery<Producto> query;
		query = entityManager.createNamedQuery("Producto.findByNombre", Producto.class);
		query.setParameter("nombre", nombre);
		
		List<Producto> resultList = query.getResultList();
		
		
		 return resultList.size()>0 ? resultList.get(0) : null;
	}
	
	@Transactional
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

	@Transactional
	@Override
	public void baja(String nombreProducto) {
		
		Producto aux = buscarPorNombre(nombreProducto);
		if(aux != null )entityManager.remove(aux);
		
	}
	@Transactional
	@Override
	public void modificar(Producto p) {
		entityManager.merge(p);
		
	}

	@Override
	public double precioMedioSeccion(String seccion) {
		String jpql="select avg(p.precio) from Producto p where p.seccion  =: seccion";
		TypedQuery<Double> query = entityManager.createNamedQuery(jpql, Double.class);
		query.setParameter("seccion", seccion);
		return query.getSingleResult();
	}
	
	
	


}
