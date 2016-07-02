package br.com.guedes.vacina.dao;

import br.com.guedes.vacina.model.Usuario;
import br.com.guedes.vacina.util.BusinessException;

public interface UsuarioDao {

	/**
	 * 
	 * @param email
	 * @param senha
	 * @return
	 * @throws BusinessException
	 */
	public Usuario efetuarLogin(final String email, final String senha) 
			throws BusinessException;
	
	/**
	 * 
	 * @param email
	 * @return
	 * @throws BusinessException
	 */
	public Usuario obterUsuarioPorEmail(final String email) 
			throws BusinessException;
}
