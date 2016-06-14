package br.com.guedes.vacina.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="TBL_VACINA_FAIXA_ETARIA")
public class VacinaFaixaEtaria implements Serializable {

	private static final long serialVersionUID = -2910764314932798095L;

	@Id
	@Column(name="VFE_CODIGO")
	private Integer vfeCodigo;
	
	@Column(name="VFE_NOME")
	private String vfeNome;
	
	@Column(name="VFE_IDADE_INICIO")
	private int vfeIdadeInicio;
	
	@Column(name="VFE_IDADE_FIM")
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
