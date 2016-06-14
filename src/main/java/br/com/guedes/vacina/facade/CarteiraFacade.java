package br.com.guedes.vacina.facade;

import br.com.guedes.vacina.util.IntegrationException;
import br.com.guedes.vacina.vo.CarteiraVO;

public interface CarteiraFacade {

	/**
	 * 
	 * @param carteiraVO CarteiraVO
	 * @throws IntegrationException
	 */
	public void salvar(CarteiraVO carteiraVO) 
			throws IntegrationException;
	
	/**
	 * 
	 * @param carteiraVO CarteiraVO
	 * @throws IntegrationException
	 */
	public void excluir(CarteiraVO carteiraVO) 
			throws IntegrationException;
}
