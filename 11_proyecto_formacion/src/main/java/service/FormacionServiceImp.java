package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Alumno;
import model.Curso;

@Service
public class FormacionServiceImp implements FormacionService {
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<String> cursos() {
		String jpql = "select distinct(c.nombre) from Curso c";
		TypedQuery<String> query;
		query = entityManager.createQuery(jpql, String.class);

		List<String> list = query.getResultList();
		return list.size() > 0 ? list : null;
	}

	@Override
	public List<Alumno> alumnosCurso(String nombreCurso) {

		String jpql = "select a from Alumno a join a.cursos c where c.nombre=:nombre";
		TypedQuery<Alumno> query;
		query = entityManager.createQuery(jpql, Alumno.class);
		query.setParameter(1, nombreCurso);

		List<Alumno> list = query.getResultList();
		return list.size() > 0 ? list : null;
	}

	@Override
	public List<Curso> cursoMatriculadoAlumno(String usuario) {
		String jpql = "select distinct(c) from Curso c join c.alumnos a where a.usuario =?1";
		TypedQuery<Curso> query;
		query = entityManager.createQuery(jpql, Curso.class);
		query.setParameter(1, usuario);
		List<Curso> list = query.getResultList();
		return list.size() > 0 ? list : null;
	}

	@Override
	public Alumno validarUsuario(String usuario, String contraseña) {
		String jpql = "select a from Alumno a where a.usuario =?1 and a.password=?2 ";
		TypedQuery<Alumno> query;
		query = entityManager.createQuery(jpql, Alumno.class);
		query.setParameter(1, usuario);
		query.setParameter(2, contraseña);

		List<Alumno> list = query.getResultList();
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public Alumno buscarAlumno(String usuario) {
		String jpql = "select a from Alumno a where a.usuario =?1";
		TypedQuery<Alumno> query;
		query = entityManager.createQuery(jpql, Alumno.class);
		query.setParameter(1, usuario);
		List<Alumno> list = query.getResultList();
		return list.size() > 0 ? list.get(0) : null;
	}
	
	@Transactional
	@Override
	public boolean matricularAlumno(String usuario, int idCurso) {
		
		Alumno auxA = buscarAlumno(usuario);
		Curso auxC = buscarCurso(idCurso);
		auxA.getCursos().add(auxC);
		entityManager.merge(auxA);
		
		return true;
		
	}

	@Override
	public Curso buscarCurso(int id) {
		String jpql = "select c from Curso c where c.idCurso =?1";
		TypedQuery<Curso> query;
		query = entityManager.createQuery(jpql, Curso.class);
		query.setParameter(1, id);
		List<Curso> list = query.getResultList();
		return list.size() > 0 ? list.get(0) : null;
	}
}
