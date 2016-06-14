package br.com.guedes.vacina.vo;

import java.io.Serializable;

public class VacinaVO implements Serializable {

	private static final long serialVersionUID = 8685057316008788918L;
	
	private Integer varCodigo;
	private String vacNome;
	private String vacComentario;
	private boolean vacFlagRedePublica;
	private String vacObsRedePublica;
	private boolean vacFlagRedePrivada;
	private String vacObsRedePrivada;
	private String vacEsquemaRecomendacao;
	private boolean vacNaoGestante;
	private String vacGestante;
	private String vacPuerpera;
	private String vacQuandoIndicar;
	private VacinaFaixaEtariaVO vacinaFaixaEtariaVO;

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

	public VacinaFaixaEtariaVO getVacinaFaixaEtariaVO() {
		return vacinaFaixaEtariaVO;
	}

	public void setVacinaFaixaEtariaVO(VacinaFaixaEtariaVO vacinaFaixaEtariaVO) {
		this.vacinaFaixaEtariaVO = vacinaFaixaEtariaVO;
	}
}
