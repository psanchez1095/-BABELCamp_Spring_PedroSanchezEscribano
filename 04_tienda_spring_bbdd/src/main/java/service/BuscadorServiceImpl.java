package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import model.Producto;

//Instancia una clase mediante Spring
@Service
public class BuscadorServiceImpl implements BuscadorService {
	
	@Autowired
	JdbcTemplate template;

	public BuscadorServiceImpl() {
	}

	@Override
	public List<Producto> buscar(String seccion) {
		 return template.query("SELECT * FROM productos WHERE seccion LIKE ?", 
				 (rs,f)->new Producto(rs.getInt("id"),
				 rs.getString("nombre"),
				 rs.getString("seccion"),
				 rs.getDouble("precio"),
				 rs.getInt("stock")),
				 seccion);
	}

	@Override
	public void alta(Producto p) {
		String sql ="insert into productos(nombre,seccion,precio,stock) values(?,?,?,?)";
		template.update(sql, p.getNombre(),p.getSeccion(),p.getPrecio(),p.getStock());
	}

	@Override
	public void baja(String nombre) {
		String sql ="delete from productos where nombre = ?";
		template.update(sql, nombre);

	}

	@Override
	public void modificar(Producto p) {
		String sql ="update productos set precio = ? where nombre = ?";
		template.update(sql, p.getPrecio(),p.getNombre());
	}

}
