package br.com.pfood.enumerated;

public enum ClienteSituacaoEnum {
	
	A("Ativo"),
	I("Inativo"),
	B("Bloqueado"),
	N("Negativado"),
	E("Em estudo"),
	V("Vip");
	private String situacao;

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	private ClienteSituacaoEnum(String situacao) {
		this.situacao = situacao;
	}
	
	

}
