package br.com.guedes.vacina.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="TBL_CARTEIRA")
public class Carteira implements Serializable {

	private static final long serialVersionUID = 6973370860870150232L;

	@Id
	@Column(name="CAR_CODIGO")
	private Integer carCodigo;
	
	@Column(name="CAR_NOME")
	private String carNome;
	
	@Column(name="CAR_DATANASCIMENTO")
	private String carDataNascimento;
	
	@Column(name="CAR_SEXO")
	private String carSexo;
	
	@Column(name="CAR_NOTIFICACAO")
	private String carNotificacao;
	
	@Column(name="CAR_FOTO")
	private String carFoto;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="USU_CODIGO")
	private Usuario usuario;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "TBL_CARTEIRA_VACINA_FAIXA_ETARIA", catalog = "mkyongdb", joinColumns = { 
			@JoinColumn(name = "CAR_CODIGO", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "VFE_CODIGO", nullable = false, updatable = false) })
	private Set<VacinaFaixaEtaria> listaVacinaFaixaEtaria;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "TBL_VACINA_TOMADA", catalog = "mkyongdb", joinColumns = { 
			@JoinColumn(name = "CAR_CODIGO", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "VAC_CODIGO", nullable = false, updatable = false) })
	private Set<Vacina> listaVacinasTomadas;

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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	public Set<VacinaFaixaEtaria> getListaVacinaFaixaEtaria() {
		return listaVacinaFaixaEtaria;
	}

	public void setListaVacinaFaixaEtaria(Set<VacinaFaixaEtaria> listaVacinaFaixaEtaria) {
		this.listaVacinaFaixaEtaria = listaVacinaFaixaEtaria;
	}

	public Set<Vacina> getListaVacinasTomadas() {
		return listaVacinasTomadas;
	}

	public void setListaVacinasTomadas(Set<Vacina> listaVacinasTomadas) {
		this.listaVacinasTomadas = listaVacinasTomadas;
	}
}
