package br.com.guedes.vacina.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@IdClass(VacinaTomadaPk.class)
@Table(name="TBL_VACINA_TOMADA")
public class VacinaTomada implements Serializable {

	private static final long serialVersionUID = -1142629365521043341L;

	@Id
    private Carteira carteira;

    @Id
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
