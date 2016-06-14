package br.com.guedes.vacina.dao;

import br.com.guedes.vacina.model.Usuario;
import br.com.guedes.vacina.util.BusinessException;
import br.com.guedes.vacina.util.IntegrationException;

public interface UsuarioDao {

	/**
	 * 
	 * @param email
	 * @param senha
	 * @return
	 * @throws BusinessException
	 * @throws IntegrationException
	 */
	public Usuario efetuarLogin(final String email, final String senha) 
			throws BusinessException, IntegrationException;
	
	/**
	 * 
	 * @param email
	 * @return
	 * @throws BusinessException
	 * @throws IntegrationException
	 */
	public Usuario obterUsuarioPorEmail(final String email) 
			throws BusinessException, IntegrationException;
}
