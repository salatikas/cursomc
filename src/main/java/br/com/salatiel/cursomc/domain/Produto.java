package br.com.salatiel.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Double preco;

	@JsonIgnore // Omitir a lista de categorias para cada produto
	@ManyToMany // Relacionamento N:N
	// Define qual tabela vai realizar o N:N no BD Relacinal
	@JoinTable(name = "PRODUTO_CATEGORIA", // NOME DA TABELA
			joinColumns = @JoinColumn(name = "produto_id"), // CHAVE ESTRANGEIRA CORRESP. AO PRODUTO
			inverseJoinColumns = @JoinColumn(name = "categoria_id")) // CHAVE ESTRANGEIRA REF CATEGORIA

	private List<Categoria> categorias = new ArrayList<>();

	// SET PARA GARANTIR QUE NÃO TERÃO ITENS REPETIDOS NO MESMO PEDIDO
	@JsonIgnore
	@OneToMany (mappedBy = "id.produto")//mapeado pelo id.produto
	private Set<ItemPedido> itens = new HashSet<>();

	public Produto() {

	}

	// categorias não faz parte do Construtor pois é uma Coleção
	public Produto(Integer id, String nome, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}
	
	@JsonIgnore
	public List<Pedido> getPedidos(){
		//INICIAR UMMA LISTA DOS PEDIDOS
		List<Pedido> lista = new ArrayList<>();
		//PARA CADA ITEM DE PEDIDO X QUE EXISTIR NA LISTA DE ITENS, VOU ADICIONAR ELE NA MINHA LISTA
		for(ItemPedido x : itens) {
			lista.add(x.getPedido());
		}
		return lista;	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}

	// GENERATE HASHCODE AND EQUALS SOMENTE COM BASE NO ID
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
