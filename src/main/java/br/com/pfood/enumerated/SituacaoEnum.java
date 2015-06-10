package br.com.pfood.enumerated;

public enum SituacaoEnum {

	A("Ativo"),
	I("Inativo"),
	T("Transicao"),
	Z("Processamento");
	
	private String situacao;

	private SituacaoEnum(String situacao) {
		this.situacao = situacao;
	}
	
	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
}
