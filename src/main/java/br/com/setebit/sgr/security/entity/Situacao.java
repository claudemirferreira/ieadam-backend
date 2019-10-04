package br.com.setebit.sgr.security.entity;

public enum Situacao {

	ATIVO("A"), INATIVO("I");
	
	private String situacao;
	
	Situacao(String situacao) {
		this.situacao = situacao;
	}
	
	public String getSituacao() {
		return this.situacao;
	}
}
