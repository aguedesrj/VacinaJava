package br.com.guedes.vacina.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="TBL_VACINA")
public class Vacina implements Serializable {

	private static final long serialVersionUID = -4712370481746023678L;

	@Id
	@Column(name="VAC_CODIGO")
	private Integer varCodigo;
	
	@Column(name="VAC_NOME")
	private String vacNome;
	
	@Column(name="VAC_COMENTARIO")
	private String vacComentario;
	
	@Column(name="VAC_FLAG_REDE_PUBLICA")
	private boolean vacFlagRedePublica;
	
	@Column(name="VAC_OBS_REDE_PUBLICA")
	private String vacObsRedePublica;
	
	@Column(name="VAC_FLAG_REDE_PRIVADA")
	private boolean vacFlagRedePrivada;
	
	@Column(name="VAC_OBS_REDE_PRIVADA")
	private String vacObsRedePrivada;
	
	@Column(name="VAC_ESQUEMA_RECOMENDACAO")
	private String vacEsquemaRecomendacao;
	
	@Column(name="VAC_NAO_GESTANTE")
	private boolean vacNaoGestante;
	
	@Column(name="VAC_GESTANTE")
	private String vacGestante;
	
	@Column(name="VAC_PUERPERA")
	private String vacPuerpera;
	
	@Column(name="VAR_QUANDO_INDICAR")
	private String vacQuandoIndicar;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="VFE_CODIGO")
	private VacinaFaixaEtaria vacinaFaixaEtaria;

	public Integer getVarCodigo() {
		return varCodigo;
	}

	public void setVarCodigo(Integer varCodigo) {
		this.varCodigo = varCodigo;
	}

	public String getVacNome() {
		return vacNome;
	}

	public void setVacNome(String vacNome) {
		this.vacNome = vacNome;
	}

	public String getVacComentario() {
		return vacComentario;
	}

	public void setVacComentario(String vacComentario) {
		this.vacComentario = vacComentario;
	}

	public boolean isVacFlagRedePublica() {
		return vacFlagRedePublica;
	}

	public void setVacFlagRedePublica(boolean vacFlagRedePublica) {
		this.vacFlagRedePublica = vacFlagRedePublica;
	}

	public String getVacObsRedePublica() {
		return vacObsRedePublica;
	}

	public void setVacObsRedePublica(String vacObsRedePublica) {
		this.vacObsRedePublica = vacObsRedePublica;
	}

	public boolean isVacFlagRedePrivada() {
		return vacFlagRedePrivada;
	}

	public void setVacFlagRedePrivada(boolean vacFlagRedePrivada) {
		this.vacFlagRedePrivada = vacFlagRedePrivada;
	}

	public String getVacObsRedePrivada() {
		return vacObsRedePrivada;
	}

	public void setVacObsRedePrivada(String vacObsRedePrivada) {
		this.vacObsRedePrivada = vacObsRedePrivada;
	}

	public String getVacEsquemaRecomendacao() {
		return vacEsquemaRecomendacao;
	}

	public void setVacEsquemaRecomendacao(String vacEsquemaRecomendacao) {
		this.vacEsquemaRecomendacao = vacEsquemaRecomendacao;
	}

	public boolean isVacNaoGestante() {
		return vacNaoGestante;
	}

	public void setVacNaoGestante(boolean vacNaoGestante) {
		this.vacNaoGestante = vacNaoGestante;
	}

	public String getVacGestante() {
		return vacGestante;
	}

	public void setVacGestante(String vacGestante) {
		this.vacGestante = vacGestante;
	}

	public String getVacPuerpera() {
		return vacPuerpera;
	}

	public void setVacPuerpera(String vacPuerpera) {
		this.vacPuerpera = vacPuerpera;
	}

	public String getVacQuandoIndicar() {
		return vacQuandoIndicar;
	}

	public void setVacQuandoIndicar(String vacQuandoIndicar) {
		this.vacQuandoIndicar = vacQuandoIndicar;
	}

	public VacinaFaixaEtaria getVacinaFaixaEtaria() {
		return vacinaFaixaEtaria;
	}

	public void setVacinaFaixaEtaria(VacinaFaixaEtaria vacinaFaixaEtaria) {
		this.vacinaFaixaEtaria = vacinaFaixaEtaria;
	}
}
