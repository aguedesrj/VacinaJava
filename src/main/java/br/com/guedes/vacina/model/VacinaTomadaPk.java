package br.com.guedes.vacina.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class VacinaTomadaPk implements Serializable {

	private static final long serialVersionUID = 3851472835513735691L;

	@ManyToOne
	@JoinColumn(name = "CAR_CODIGO", referencedColumnName = "CAR_CODIGO")
	private Carteira carteira;	

	@ManyToOne
	@JoinColumn(name = "VAC_CODIGO", referencedColumnName = "VAC_CODIGO")
	private Vacina vacina;

	public Carteira getCarteira() {
		return carteira;
	}

	public void setCarteira(Carteira carteira) {
		this.carteira = carteira;
	}

	public Vacina getVacina() {
		return vacina;
	}

	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}
}
