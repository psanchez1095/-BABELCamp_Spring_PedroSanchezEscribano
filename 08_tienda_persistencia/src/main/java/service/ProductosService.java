package service;

import java.util.List;

import model.Producto;

public interface ProductosService {
	
	/**
	 * Metodo que se encargar de buscar los productos de la tematica que le llega por parametro
	 * @param tematica parametro string que contiene la tematica a buscar
	 * @return devuelve una lista de productos en caso de éxito,null en caso contrario
	 * */
	List<Producto> buscarPorSeccion(String tematica);
	
	/**
	 * Metodo que se encargar de buscar los productos de la tematica que le llega por parametro
	 * @param tematica parametro string que contiene la tematica a buscar
	 * @return devuelve una lista de productos en caso de éxito,null en caso contrario
	 * */
	Producto buscar(int id);
	
	/**
	 * Metodo que se encargar de buscar los productos de la tematica que le llega por parametro
	 * @param nombre parametro string que contiene la tematica a buscar
	 * @return devuelve una lista de productos en caso de éxito,null en caso contrario
	 * */
	Producto buscarPorNombre(String nombre);
	
	/** 
	 *  Metodo que se encargar de dar de alta un producto en el sistema
	 * @param p parametro de tipo Producto a dar de alta
	 * */
	void alta(Producto p);
	/** 
	 * Metodo que se encargar de eliminar un producto en el sistema
	 * @param nombreProducto parametro string que contiene el nombre del vehiculo
	 * que se va a eliminar 
	 * */
	void baja(String nombreProducto);
	
	/** 
	 * Metodo que se encargar de modificar un producto existente en el sistema
	 * @param p parametro de tipo Producto a modificar 
	 * */
	void modificar(Producto p);
}
