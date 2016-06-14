package br.com.guedes.vacina.facade;

import java.util.List;

import br.com.guedes.vacina.util.IntegrationException;
import br.com.guedes.vacina.vo.VacinaTomadaVO;
import br.com.guedes.vacina.vo.VacinaVO;

public interface VacinaFacade {
	
	/**
	 * 
	 * @return
	 * @throws IntegrationException
	 */
	public List<VacinaVO> listarTodasVacinas() 
			throws IntegrationException;

	/**
	 * 
	 * @param vacinaTomadaVO VacinaTomadaVO
	 * @throws IntegrationException
	 */
	public void salvarVacinaTomada(VacinaTomadaVO vacinaTomadaVO) 
			throws IntegrationException;
	
	/**
	 * 
	 * @param vacinaTomadaVO VacinaTomadaVO
	 * @throws IntegrationException
	 */
	public void excluirVacinaTomada(VacinaTomadaVO vacinaTomadaVO) 
			throws IntegrationException;
}
