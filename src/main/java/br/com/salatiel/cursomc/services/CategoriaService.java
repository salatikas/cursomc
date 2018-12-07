package br.com.salatiel.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.salatiel.cursomc.domain.Categoria;
import br.com.salatiel.cursomc.repositories.CategoriaRepository;
import br.com.salatiel.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired // Instanciar o repositório automaticamente pelo Spring
	private CategoriaRepository repo;

	/* Esse método vai no BD, busca o Id correpondente e retorna o objeto */
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: " + Categoria.class.getName()));

	}

}
