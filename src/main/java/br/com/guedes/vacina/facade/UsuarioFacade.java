package br.com.guedes.vacina.facade;

import br.com.guedes.vacina.util.BusinessException;
import br.com.guedes.vacina.vo.UsuarioVO;

public interface UsuarioFacade {

	/**
	 * 
	 * @param usuarioVO
	 * @return
	 * @throws BusinessException
	 */
	public UsuarioVO efetuarLogin(UsuarioVO usuarioVO) 
			throws BusinessException, Exception;
	
	/**
	 * 
	 * @param email
	 * @return
	 * @throws BusinessException
	 */
	public UsuarioVO obterUsuarioPorEmail(final String email) 
			throws BusinessException;
	
	/**
	 * 
	 * @param usuarioVO
	 * @throws Exception
	 */
	public void salvar(UsuarioVO usuarioVO) 
			throws Exception;
	
	/**
	 * 
	 * @param email
	 * @throws Exception
	 */
	public void enviarEmail(final String email) 
			throws Exception;
}
