package br.com.guedes.vacina.vo;

import java.io.Serializable;

public class VacinaFaixaEtariaVO implements Serializable {

	private static final long serialVersionUID = 6366470292390663555L;
	
	private Integer vfeCodigo;
	private String vfeNome;
	private int vfeIdadeInicio;
	private int vfeIdadeFim;

	public Integer getVfeCodigo() {
		return vfeCodigo;
	}

	public void setVfeCodigo(Integer vfeCodigo) {
		this.vfeCodigo = vfeCodigo;
	}

	public String getVfeNome() {
		return vfeNome;
	}

	public void setVfeNome(String vfeNome) {
		this.vfeNome = vfeNome;
	}

	public int getVfeIdadeInicio() {
		return vfeIdadeInicio;
	}

	public void setVfeIdadeInicio(int vfeIdadeInicio) {
		this.vfeIdadeInicio = vfeIdadeInicio;
	}

	public int getVfeIdadeFim() {
		return vfeIdadeFim;
	}

	public void setVfeIdadeFim(int vfeIdadeFim) {
		this.vfeIdadeFim = vfeIdadeFim;
	}
}
