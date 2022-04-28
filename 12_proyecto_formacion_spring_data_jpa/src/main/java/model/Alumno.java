package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Alumno {
	@Id
	private String usuario;
	private String password;
	private String nombre;
	private String email;
	private int edad;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "matriculas",
	joinColumns = @JoinColumn(name = "usuario", referencedColumnName = "usuario"),
	inverseJoinColumns = @JoinColumn(name = "idCurso", referencedColumnName = "idCurso"))
	private List<Curso> cursos;

	public Alumno(String usuario, String password, String nombre, String email, int edad) {
		super();
		this.usuario = usuario;
		this.password = password;
		this.nombre = nombre;
		this.email = email;
		this.edad = edad;
	}

}
