package br.com.guedes.vacina.dao;

import java.util.ArrayList;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import br.com.guedes.vacina.model.Usuario;
import br.com.guedes.vacina.util.BusinessException;

@Repository
public class UsuarioDaoImpl extends HibernateDaoSupport implements UsuarioDao {

	/*
	 * (non-Javadoc)
	 * @see br.com.guedes.vacina.dao.UsuarioDao#efetuarLogin(java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public Usuario efetuarLogin(final String email, final String senha) 
			throws BusinessException {
		StringBuilder hql = new StringBuilder();
		hql.append("from Usuario ");
		hql.append(" where usuEmail = '" + email + "'");
		hql.append(" and usuSenh = '" + senha + "'");
		
		ArrayList<Usuario> listaUsuarios = (ArrayList<Usuario>) getHibernateTemplate().find(hql.toString());
		if(listaUsuarios != null && !listaUsuarios.isEmpty()) {
			return listaUsuarios.get(0);
		}
		throw new BusinessException("Email ou senha inválidos.");
	}
	
	/*
	 * (non-Javadoc)
	 * @see br.com.guedes.vacina.dao.UsuarioDao#obterUsuarioPorEmail(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public Usuario obterUsuarioPorEmail(final String email) 
			throws BusinessException  {
		StringBuilder hql = new StringBuilder();
		hql.append("from Usuario ");
		hql.append(" where usuEmail = '" + email + "'");
		
		ArrayList<Usuario> listaUsuarios = (ArrayList<Usuario>) getHibernateTemplate().find(hql.toString());
		if(listaUsuarios != null && !listaUsuarios.isEmpty()) {
			return listaUsuarios.get(0);
		}
		throw new BusinessException("Email inexistente.");
//		try {
//
//		} catch (Exception e) {
//			throw new IntegrationException("Não foi possível obter dados do usuário pelo email.");
//		}
	}
}
