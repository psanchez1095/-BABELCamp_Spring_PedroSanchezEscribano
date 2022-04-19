package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Producto{
	
	private int idProducto;
	private String nombre;
	private String seccion;
	private double precio;
	private int stock;

	}
	

