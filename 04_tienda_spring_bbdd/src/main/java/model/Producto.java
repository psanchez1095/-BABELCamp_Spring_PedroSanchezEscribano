package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Producto implements RowMapper<Producto>{
	
	private int idProducto;
	private String nombre;
	private String seccion;
	private double precio;
	private int stock;
	@Override
	public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
		   return new Producto(rs.getInt("id"), rs.getString("nombre"),rs.getString("seccion"),rs.getDouble("precio"), rs.getInt("stock"));
    }
	

	}
	

