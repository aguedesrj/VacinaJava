package br.com.guedes.vacina.facade;

import br.com.guedes.vacina.util.BusinessException;
import br.com.guedes.vacina.util.IntegrationException;
import br.com.guedes.vacina.vo.UsuarioVO;

public interface UsuarioFacade {

	/**
	 * 
	 * @param usuarioVO
	 * @return
	 * @throws BusinessException
	 * @throws IntegrationException
	 */
	public UsuarioVO efetuarLogin(UsuarioVO usuarioVO) 
			throws BusinessException, IntegrationException;
	
	/**
	 * 
	 * @param email
	 * @return
	 * @throws BusinessException
	 * @throws IntegrationException
	 */
	public UsuarioVO obterUsuarioPorEmail(final String email) 
			throws BusinessException, IntegrationException;
	
	/**
	 * 
	 * @param usuarioVO
	 * @throws IntegrationException
	 */
	public void salvar(UsuarioVO usuarioVO) 
			throws IntegrationException;
	
	/**
	 * 
	 * @param email
	 * @throws IntegrationException
	 */
	public void enviarEmail(final String email) 
			throws IntegrationException;
}
