package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "alumnos")
@NamedQuery(name = "Alumno.findByCurso", query = "select obj from Alumno obj where obj.curso = :curso")
@NamedQuery(name = "Alumno.findByNombre", query = "select obj from Alumno obj where obj.nombre = :nombre")
@NamedQuery(name = "Alumno.findCursos", query = "select DISTINCT(obj.curso) from Alumno obj")
public class Alumno{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String dni;
	@Column(name="nombre")
	private String nombre;
	@Column(name="edad")
	private String edad;
	@Column(name="email")
	private String email;
	
	@ManyToOne()
    @JoinColumn(name="curso",referencedColumnName = "idCurso")
    private Curso curso;

	
	}
	

