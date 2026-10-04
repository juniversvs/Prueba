package com.cibertec.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cibertec.app.entity.Producto;
import com.cibertec.app.service.CategoriaService;
import com.cibertec.app.service.ProductoService;

@Controller
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	//este lo tube que cambiar ya que no funcionaba y la verdad que no lo termine de entender
	@GetMapping("/producto")
	public String listProductos(Model model) {
	    List<Producto> productos = productoService.listarTodosProductos();
	    model.addAttribute("productos", productos);
	    return "producto/index";
	}
	//este es el antiguo si es que quieren comparar, el cual creo que lo copie mal
	/*@GetMapping("/producto")
	public String listProductos(Model model) {
		Producto producto = new Producto();
		producto.setCodigo(productoService.generarCodigoProducto());
		model.addAttribute("producto", producto);
		model.addAttribute("categoriaList", categoriaService.listarTodosCategoria());
		return "producto/create";
	}*/
	
	@PostMapping("/producto")
	public String saveProducto(Producto producto) {
	    productoService.guardarProducto(producto);
	    return "redirect:/producto";
	}
	
	//aca esta la parte donde integro el nuevo producto, la verdad que no pude hacerlo como el profesor asi que hice uno como podia
	@GetMapping("/producto/new")//este mismo link lo puse en la vista del header compartido de agregar producto
	public String nuevoProducto(Model model) {
	    Producto producto = new Producto();
	    producto.setCodigo(productoService.generarCodigoProducto());
	    model.addAttribute("producto", producto);
	    model.addAttribute("categoriaList", categoriaService.listarTodosCategoria()
	    );

	    return "producto/create";
	}
	
	//El resto esta joya
	

	@GetMapping("/producto/edit/{id}")
	public String editProducto(@PathVariable Integer id, Model model) {
	    Producto producto = productoService.buscarProductoById(id);
	    model.addAttribute("producto", producto);
	    model.addAttribute("categoriaList", categoriaService.listarTodosCategoria());
	    return "producto/edit";
	}
	
	@PostMapping("/producto/{id}")
	public String updateProducto(@PathVariable Integer id, Producto producto) {
		Producto existentProducto = productoService.buscarProductoById(id);
		existentProducto.setIdProd(id);
		existentProducto.setDescripcion(producto.getDescripcion());
		existentProducto.setPrecioVenta(producto.getPrecioVenta());
		existentProducto.setPrecioCompra(producto.getPrecioCompra());
		existentProducto.setStock(producto.getStock());
		existentProducto.setCategoria(producto.getCategoria());
		productoService.actulizarProducto(existentProducto);
		return "redirect:/producto";
	}
	
	@GetMapping("/producto/delete/{id}")
	public String deleteProducto(@PathVariable Integer id) {
		productoService.eliminarProductoById(id);
		return "redirect:/producto";
	}


}
