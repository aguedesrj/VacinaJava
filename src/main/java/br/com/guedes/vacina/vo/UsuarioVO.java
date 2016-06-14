package br.com.guedes.vacina.vo;

import java.io.Serializable;

public class UsuarioVO implements Serializable {

	private static final long serialVersionUID = 857340679230842169L;

	private Integer usuCodigo;
	private String usuNome;
	private String usuEmail;
	private String usuSenha;
	
	public Integer getUsuCodigo() {
		return usuCodigo;
	}
	public void setUsuCodigo(Integer usuCodigo) {
		this.usuCodigo = usuCodigo;
	}
	
	public String getUsuEmail() {
		return usuEmail;
	}
	
	public void setUsuEmail(String usuEmail) {
		this.usuEmail = usuEmail;
	}
	
	public String getUsuSenha() {
		return usuSenha;
	}
	
	public void setUsuSenha(String usuSenha) {
		this.usuSenha = usuSenha;
	}
	public String getUsuNome() {
		return usuNome;
	}
	public void setUsuNome(String usuNome) {
		this.usuNome = usuNome;
	}
}
