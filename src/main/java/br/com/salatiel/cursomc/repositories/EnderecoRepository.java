package br.com.salatiel.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.salatiel.cursomc.domain.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
	/*
	 * Essa classe vai ser capaz de realizar operações de acesso a dados (CRUD),
	 * referentes ao Objeto Categoria, e por sua vez está mapeado com a tabela
	 * Categoria no BD
	 */
}
