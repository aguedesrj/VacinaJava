package br.com.guedes.vacina.vo;

import java.io.Serializable;

public class CarteiraVO implements Serializable {

	private static final long serialVersionUID = 991173635305704990L;
	
	private Integer carCodigo;
	private String carNome;
	private String carDataNascimento;
	private String carSexo;
	private String carNotificacao;
	private String carFoto;
	private Integer usuCodigo;

	public Integer getCarCodigo() {
		return carCodigo;
	}

	public void setCarCodigo(Integer carCodigo) {
		this.carCodigo = carCodigo;
	}

	public String getCarNome() {
		return carNome;
	}

	public void setCarNome(String carNome) {
		this.carNome = carNome;
	}

	public String getCarDataNascimento() {
		return carDataNascimento;
	}

	public void setCarDataNascimento(String carDataNascimento) {
		this.carDataNascimento = carDataNascimento;
	}

	public String getCarSexo() {
		return carSexo;
	}

	public void setCarSexo(String carSexo) {
		this.carSexo = carSexo;
	}

	public String getCarNotificacao() {
		return carNotificacao;
	}

	public void setCarNotificacao(String carNotificacao) {
		this.carNotificacao = carNotificacao;
	}

	public String getCarFoto() {
		return carFoto;
	}

	public void setCarFoto(String carFoto) {
		this.carFoto = carFoto;
	}

	public Integer getUsuCodigo() {
		return usuCodigo;
	}

	public void setUsuCodigo(Integer usuCodigo) {
		this.usuCodigo = usuCodigo;
	}
}
