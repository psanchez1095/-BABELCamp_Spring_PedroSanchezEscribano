package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import model.Curso;

@Repository
public class CursosDaoImp implements CursosDao {
	@PersistenceContext
	EntityManager entityManager;
	@Override
	public List<Curso> findByAlumno(String usuario) {
		String jpql = "select c from Curso c join c.alumnos a where a.usuario =?1";
		TypedQuery<Curso> query;
		query = entityManager.createQuery(jpql, Curso.class);
		query.setParameter(1, usuario);
		List<Curso> list = query.getResultList();
		return list;
	}

	@Override
	public List<String> findAll() {
		String jpql = "select distinct(c.nombre) from Curso c";
		TypedQuery<String> query;
		query = entityManager.createQuery(jpql, String.class);

		return query.getResultList();
	
	}

	@Override
	public Curso findById(int id) {
		return entityManager.find(Curso.class, id);
	}

	
}
