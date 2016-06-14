package br.com.guedes.vacina.dao;

import java.util.ArrayList;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import br.com.guedes.vacina.model.Usuario;
import br.com.guedes.vacina.util.BusinessException;
import br.com.guedes.vacina.util.IntegrationException;

@Repository
public class UsuarioDaoImpl extends HibernateDaoSupport implements UsuarioDao {

	/*
	 * (non-Javadoc)
	 * @see br.com.guedes.vacina.dao.UsuarioDao#efetuarLogin(java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public Usuario efetuarLogin(final String email, final String senha) 
			throws BusinessException, IntegrationException {
		try {
			StringBuilder hql = new StringBuilder();
			hql.append("from Usuario ");
			hql.append(" where usuEmail = '" + email + "'");
			hql.append(" and usuSenha = '" + senha + "'");
			
			ArrayList<Usuario> listaUsuarios = (ArrayList<Usuario>) getHibernateTemplate().find(hql.toString());
			if(listaUsuarios != null && !listaUsuarios.isEmpty()) {
				return listaUsuarios.get(0);
			}
			throw new BusinessException("Email ou senha inválidos.");
		} catch (Exception e) {
			throw new IntegrationException("Não foi possível efetuar login.");
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see br.com.guedes.vacina.dao.UsuarioDao#obterUsuarioPorEmail(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public Usuario obterUsuarioPorEmail(final String email) throws BusinessException, IntegrationException  {
		try {
			StringBuilder hql = new StringBuilder();
			hql.append("from Usuario ");
			hql.append(" where usuEmail = '" + email + "'");
			
			ArrayList<Usuario> listaUsuarios = (ArrayList<Usuario>) getHibernateTemplate().find(hql.toString());
			if(listaUsuarios != null && !listaUsuarios.isEmpty()) {
				return listaUsuarios.get(0);
			}
			
			throw new BusinessException("Email inexistente.");
		} catch (Exception e) {
			throw new IntegrationException("Não foi possível obter dados do usuário pelo email.");
		}
	}
}
