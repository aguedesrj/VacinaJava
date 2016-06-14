package br.com.guedes.vacina.vo;

import java.io.Serializable;

public class VacinaTomadaVO implements Serializable {

	private static final long serialVersionUID = -5773198577972825957L;
	
	private Integer carCodigo;
	private Integer varCodigo;
	
	public Integer getCarCodigo() {
		return carCodigo;
	}
	
	public void setCarCodigo(Integer carCodigo) {
		this.carCodigo = carCodigo;
	}
	
	public Integer getVarCodigo() {
		return varCodigo;
	}
	
	public void setVarCodigo(Integer varCodigo) {
		this.varCodigo = varCodigo;
	}
}
