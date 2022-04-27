package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Alumno;


@Repository
public class AlumnosDaoImp implements AlumnosDao {
	@PersistenceContext
	EntityManager entityManager;
	@Override
	public List<Alumno> findByCurso(String nombreCurso) {
		String jpql = "select a from Alumno a join a.cursos c where c.nombre=:nombre";
		TypedQuery<Alumno> query;
		query = entityManager.createQuery(jpql, Alumno.class);
		query.setParameter(1, nombreCurso);

		return query.getResultList();
		
	}

	@Override
	public Alumno findByUsuarioAndPassword(String usuario, String contraseña) {
		String jpql = "select a from Alumno a where a.usuario =?1 and a.password=?2 ";
		TypedQuery<Alumno> query;
		query = entityManager.createQuery(jpql, Alumno.class);
		query.setParameter(1, usuario);
		query.setParameter(2, contraseña);
		try {
			return query.getSingleResult();
		}catch(NoResultException ex) {
			return null;
		}
	}

	@Override
	public Alumno findById(String usuario) {
		return entityManager.find(Alumno.class,usuario);
	}
	
	
	@Override
	@Transactional
	public void update(Alumno alumno) {
		entityManager.merge(alumno);
		
	}

	@Override
	public List<Alumno> findAll() {
		String jpql = "select distinct(a) from Alumno a";
		TypedQuery<Alumno> query;
		query = entityManager.createQuery(jpql, Alumno.class);

		return query.getResultList();
	}



}
