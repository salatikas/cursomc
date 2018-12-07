package br.com.salatiel.cursomc.domain.enums;

public enum TipoCliente {
	PESSOAFISICA(1, "Pessoa Física"), PESSOAJURIDICA(2, "Pessoa Jurídica");

	private int cod;
	private String descricao;

	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	//APENAS OS GETTERS
	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(TipoCliente x : TipoCliente.values() ) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		//TRATAMENTO DE EXCEÇÃO PARA CÓDIGO INVÁLIDO
		throw new IllegalArgumentException("ID inválido: " + cod);
	}
	
}
