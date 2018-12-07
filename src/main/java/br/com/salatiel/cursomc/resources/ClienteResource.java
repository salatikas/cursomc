package br.com.salatiel.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.salatiel.cursomc.domain.Cliente;
import br.com.salatiel.cursomc.services.ClienteService;

//Anotações
@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	// VERBO HTTP(EX: get - usar o correto para cada operação)

	/*
	 * Encontrar uma categoria com um id ResponseEntity: Encapsula varias
	 * informações de uma resposta HTTP para um serviço REST
	 */
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Cliente obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

}
