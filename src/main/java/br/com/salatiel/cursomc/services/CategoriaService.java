package br.com.salatiel.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.salatiel.cursomc.domain.Categoria;
import br.com.salatiel.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired //Instanciar o repositório automaticamente pelo Spring
	private CategoriaRepository repo;
	
	/*Esse método vai no BD, busca o Id correpondente e retorna o objeto */
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
}
