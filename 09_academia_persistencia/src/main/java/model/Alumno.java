package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@NamedQuery(name = "Alumno.findBySeccion", query = "select obj from Alumno obj where obj.curso = :curso")
@NamedQuery(name = "Alumno.findByNombre", query = "select obj from Alumno obj where obj.nombre = :nombre")
public class Alumno{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProducto;
	@Column(name="nombre")
	private String nombre;
	@Column(name="curso")
	private String curso;
	@Column(name="nota")
	private int nota;

	}
	

