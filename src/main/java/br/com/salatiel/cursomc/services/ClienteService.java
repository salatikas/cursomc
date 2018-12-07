package br.com.salatiel.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.salatiel.cursomc.domain.Cliente;
import br.com.salatiel.cursomc.repositories.ClienteRepository;
import br.com.salatiel.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired // Instanciar o repositório automaticamente pelo Spring
	private ClienteRepository repo;

	/* Esse método vai no BD, busca o Id correpondente e retorna o objeto */
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: " + Cliente.class.getName()));

	}

}
