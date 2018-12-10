package br.com.salatiel.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.salatiel.cursomc.domain.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{
	//CRIAR REPOSITORY APENAS DA SUPER CLASSE
}
