package service;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;

import model.Alumno;
import model.Curso;

@Service
public class EscuelaServiceImp implements EscuelaService{
	@PersistenceContext
	EntityManager entityManager;
	@Override
	public List<Alumno> alumnosCurso(String nombre) {
		String jpql ="select a from Alumno a where a.curso.denominacion =?1";
		TypedQuery<Alumno> query;
		query = entityManager.createQuery(jpql, Alumno.class);
		query.setParameter(1, nombre);
		List<Alumno> list = query.getResultList();
		return list.size()>0 ? list : null;
	}

	@Override
	public List<Alumno> alumnosCursoDuracion(int duracionMax) {
		String jpql ="select a from Alumno a where a.curso.duracion <=?1";
		TypedQuery<Alumno> query;
		query = entityManager.createQuery(jpql, Alumno.class);
		query.setParameter(1, duracionMax);
		
		List<Alumno> list = query.getResultList();
		return list.size()>0 ? list : null;
	}

	@Override
	public Curso cursoMatriculadoAlumno(String dni) {
		String jpql ="select c from Curso c join c.alumnos a where a.dni =: dni";
		TypedQuery<Curso> query;
		query = entityManager.createQuery(jpql, Curso.class);
		query.setParameter("dni", dni);
		List<Curso> list = query.getResultList();
		return list.size()>0 ? list.get(0) : null;
	}

	@Override
	public List<Curso> alumnosSenior(int edad) {
		String jpql ="select c from Curso c join c.alumnos a where a.edad >=?1";
		TypedQuery<Curso> query;
		query = entityManager.createQuery(jpql, Curso.class);
		query.setParameter(1, edad);
		
		List<Curso> list = query.getResultList();
		return list.size()>0 ? list : null;
	}

	@Override
	public double edadMediaCurso(String nombreCurso) {
		String jpql="select avg(p.precio) from Producto p where p.seccion  =: nombreCurso";
		TypedQuery<Double> query = entityManager.createQuery(jpql, Double.class);
		query.setParameter("nombreCurso", nombreCurso);
		return query.getSingleResult();
	}

	@Override
	public double precioCurso(String email) {
		String jpql="select c.precio from Curso c join c.alumnos a where a.email =?1";
		TypedQuery<Double> query = entityManager.createQuery(jpql, Double.class);
		query.setParameter(1, email);
		return query.getSingleResult();
	}

}
