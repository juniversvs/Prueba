package com.cibertec.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.app.entity.Producto;
import com.cibertec.app.repository.ProductoRepository;
import com.cibertec.app.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	ProductoRepository productoRepository;

	@Override
	public Producto guardarProducto(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public List<Producto> listarTodosProductos() {
		return productoRepository.findAll();
	}

	@Override
	public Producto actulizarProducto(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public void eliminarProductoById(Integer idProd) {
		productoRepository.deleteById(idProd);
		
	}

	@Override
	public Producto buscarProductoById(Integer idProd) {
		return productoRepository.findById(idProd).get();
	}

	@Override
	public Producto buscarProductoByCodigo(String codigo) {
		return productoRepository.buscarProductoByCodigo(codigo);
	}

	@Override
	public String generarCodigoProducto() {
		String ultimoCodigo = productoRepository.obtenerUltimoCodigo();
		if(ultimoCodigo == null || ultimoCodigo.isEmpty())
			return "P000001";
		String numeroTexto = ultimoCodigo.substring(1);
		int numero = Integer.parseInt(numeroTexto);
		numero++;
		return String.format("P%06d", numero);
	}
}
