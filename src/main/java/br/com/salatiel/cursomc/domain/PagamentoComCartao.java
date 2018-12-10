package br.com.salatiel.cursomc.domain;

import javax.persistence.Entity;

import br.com.salatiel.cursomc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento {
	private static final long serialVersionUID = 1L;

	private Integer numeroDeParcelas;

	public PagamentoComCartao() {
		super();
		// TODO Auto-generated constructor stub
	}

	// GENERATE CONSTRUCTORS FROM SUPERCLASS
	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
		// TODO Auto-generated constructor stub
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}

	// NÃO NECESSITA DE HASHCODE E EQUALS, POIS O ID ESTÁ NA SUPER CLASSE
}
