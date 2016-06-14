package br.com.guedes.vacina.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="TBL_USUARIO")
public class Usuario implements Serializable {

	private static final long serialVersionUID = -8761867041165680117L;

	@Id
	@Column(name="USU_CODIGO")
	private Integer usuCodigo;
	
	@Column(name="USU_NOME")
	private String usuNome;
	
	@Column(name="USU_EMAIL")
	private String usuEmail;
	
	@Column(name="USU_SENHA")
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
