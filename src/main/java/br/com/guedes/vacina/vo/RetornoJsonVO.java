package br.com.guedes.vacina.vo;

import java.io.Serializable;

public class RetornoJsonVO implements Serializable {

	private static final long serialVersionUID = 7749676484464892487L;

	private boolean sucesso;
	private int codigo;
	private String mensagem;
	
	public boolean isSucesso() {
		return sucesso;
	}
	
	public void setSucesso(boolean sucesso) {
		this.sucesso = sucesso;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
