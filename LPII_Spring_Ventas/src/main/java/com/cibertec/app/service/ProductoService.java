package com.cibertec.app.service;

import java.util.List;

import com.cibertec.app.entity.Producto;

public interface ProductoService {
	
	public Producto guardarProducto(Producto producto);
	
	public List<Producto> listarTodosProductos();
	
	public Producto actulizarProducto(Producto producto);
	
	public void eliminarProductoById(Integer idProd);
	
	public Producto buscarProductoById(Integer idProd);
	
	public Producto buscarProductoByCodigo(String codigo);
	
	public String generarCodigoProducto();

}
