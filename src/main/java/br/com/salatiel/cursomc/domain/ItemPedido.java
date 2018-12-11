package br.com.salatiel.cursomc.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	// O ID SERÁ DO TIPO DA CLASSE AUXILIAR
	@JsonIgnore
	@EmbeddedId // ID EMBUTIDO EM UM TIPO AUXILIAR
	private ItemPedidoPK id = new ItemPedidoPK();

	// CRIAR CHAVE COMPOSTA CONTENDO PRODUTO E PEDIDO
	private Double desconto;
	private Integer quantidade;
	private Double preco;

	// AS ASSOCIAÇÕES JÁ FORAM FEITAS NA CLASSE"ItemPedidoPK"

	public ItemPedido() {
		super();
	}

	// Trocar o itempedidoPk do construtor por pedido e produto
	public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) {
		super();
		// atribuir pedido e produto para a variavel id
		id.setPedido(pedido);
		id.setProduto(produto);
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	// CRIAR GETTERS DO PEDIDO E PRODUTO
	@JsonIgnore
	public Pedido getPedido() {
		return id.getPedido();
	}

	public Produto getProduto() {
		return id.getProduto();
	}

	public ItemPedidoPK getId() {
		return id;
	}

	public void setId(ItemPedidoPK id) {
		this.id = id;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
