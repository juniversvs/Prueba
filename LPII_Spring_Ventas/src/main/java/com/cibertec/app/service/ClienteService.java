package com.cibertec.app.service;

import java.util.List;

import com.cibertec.app.entity.Cliente;

public interface ClienteService {
	
	public Cliente guardarCliente(Cliente cliente);
	
	public List<Cliente>listarTodosClientes();
	
	public Cliente actualiarCliente(Cliente cliente);
	
	public void eliminarClienteById(Integer id);
	
	public Cliente buscarClienteById(Integer id);

}
