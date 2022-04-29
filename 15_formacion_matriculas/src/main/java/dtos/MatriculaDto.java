package dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MatriculaDto {
	private CursoDto cursoDto;
	private AlumnoDto alumnoDto;
	private double nota;
}
