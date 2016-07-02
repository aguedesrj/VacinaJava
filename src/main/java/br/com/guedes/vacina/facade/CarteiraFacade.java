package br.com.guedes.vacina.facade;

import br.com.guedes.vacina.vo.CarteiraVO;

public interface CarteiraFacade {

	/**
	 * 
	 * @param carteiraVO CarteiraVO
	 * @throws Exception
	 */
	public void salvar(CarteiraVO carteiraVO) 
			throws Exception;
	
	/**
	 * 
	 * @param carteiraVO CarteiraVO
	 * @throws Exception
	 */
	public void excluir(CarteiraVO carteiraVO) 
			throws Exception;
}
