package br.com.guedes.vacina.facade;

import java.util.List;

import br.com.guedes.vacina.vo.VacinaTomadaVO;
import br.com.guedes.vacina.vo.VacinaVO;

public interface VacinaFacade {
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<VacinaVO> listarTodasVacinas() 
			throws Exception;

	/**
	 * 
	 * @param vacinaTomadaVO VacinaTomadaVO
	 * @throws Exception
	 */
	public void salvarVacinaTomada(VacinaTomadaVO vacinaTomadaVO) 
			throws Exception;
	
	/**
	 * 
	 * @param vacinaTomadaVO VacinaTomadaVO
	 * @throws Exception
	 */
	public void excluirVacinaTomada(VacinaTomadaVO vacinaTomadaVO) 
			throws Exception;
}
