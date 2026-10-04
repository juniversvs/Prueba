package com.cibertec.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.app.entity.Cliente;
import com.cibertec.app.repository.ClienteRepository;
import com.cibertec.app.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	ClienteRepository clienteRepository;
	

	@Override
	public Cliente guardarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	

	@Override
	public List<Cliente> listarTodosClientes() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente actualiarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public void eliminarClienteById(Integer id) {
		clienteRepository.deleteById(id);
		
	}

	@Override
	public Cliente buscarClienteById(Integer id) {
		return clienteRepository.findById(id).get();
	}

}
