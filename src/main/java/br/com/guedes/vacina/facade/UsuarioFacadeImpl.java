package br.com.guedes.vacina.facade;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.guedes.vacina.dao.UsuarioDao;
import br.com.guedes.vacina.model.Usuario;
import br.com.guedes.vacina.util.BusinessException;
import br.com.guedes.vacina.util.IntegrationException;
import br.com.guedes.vacina.vo.UsuarioVO;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
public class UsuarioFacadeImpl implements UsuarioFacade {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioFacadeImpl.class);
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Autowired 
    private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * @see br.com.guedes.vacina.facade.UsuarioFacade#efetuarLogin(br.com.guedes.vacina.vo.UsuarioVO)
	 */
	public UsuarioVO efetuarLogin(UsuarioVO usuarioVO) 
			throws BusinessException, IntegrationException {
		Usuario usuario = usuarioDao.efetuarLogin(usuarioVO.getUsuEmail(), usuarioVO.getUsuSenha());
		
		usuarioVO.setUsuCodigo(usuario.getUsuCodigo());
		usuarioVO.setUsuNome(usuario.getUsuNome());
		
		return usuarioVO;
	}
	
	/*
	 * (non-Javadoc)
	 * @see br.com.guedes.vacina.facade.UsuarioFacade#obterUsuarioPorEmail(java.lang.String)
	 */
	public UsuarioVO obterUsuarioPorEmail(final String email) 
			throws BusinessException, IntegrationException {
		LOGGER.info("Obter email de: {}", email);
		Usuario usuario = usuarioDao.obterUsuarioPorEmail(email);
		
		UsuarioVO usuarioVO = new UsuarioVO();
		usuarioVO.setUsuCodigo(usuario.getUsuCodigo());
		usuarioVO.setUsuNome(usuario.getUsuNome());
		usuarioVO.setUsuEmail(usuario.getUsuEmail());
		
		return usuarioVO;
	}
	
	/*
	 * (non-Javadoc)
	 * @see br.com.guedes.vacina.facade.UsuarioFacade#salvar(br.com.guedes.vacina.model.Usuario)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void salvar(UsuarioVO usuarioVO) 
			throws IntegrationException {
		try {
			Usuario usuario = new Usuario();
			usuario.setUsuNome(usuarioVO.getUsuNome());
			usuario.setUsuEmail(usuarioVO.getUsuEmail());
			usuario.setUsuSenha(usuarioVO.getUsuSenha());
			
			sessionFactory.getCurrentSession().saveOrUpdate(usuario);
			sessionFactory.getCurrentSession().flush();
		} catch (Exception e) {
			throw new IntegrationException("Erro ao salvar usuário.");
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see br.com.guedes.vacina.facade.UsuarioFacade#enviarEmail(java.lang.String)
	 */
	public void enviarEmail(final String email) 
			throws IntegrationException {
		try {
			
		} catch (Exception e) {
			throw new IntegrationException("Erro ao enviar email para o usuário.");
		}
	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
