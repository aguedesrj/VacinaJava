package br.com.guedes.vacina.facade;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.guedes.vacina.model.Carteira;
import br.com.guedes.vacina.model.Usuario;
import br.com.guedes.vacina.vo.CarteiraVO;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
public class CarteiraFacadeImpl implements CarteiraFacade {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CarteiraFacadeImpl.class);
	
	@Autowired 
    private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * @see br.com.guedes.vacina.facade.CarteiraFacade#salvar(br.com.guedes.vacina.vo.CarteiraVO)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void salvar(CarteiraVO carteiraVO) 
			throws Exception {

		Carteira carteira = new Carteira();
		Usuario usuario = new Usuario();
		
		carteira.setCarCodigo(carteiraVO.getCarCodigo());
		carteira.setCarDataNascimento(carteiraVO.getCarDataNascimento());
		carteira.setCarFoto(carteiraVO.getCarFoto());
		carteira.setCarNome(carteiraVO.getCarNome());
		carteira.setCarNotificacao(carteiraVO.getCarNotificacao());
		carteira.setCarSexo(carteiraVO.getCarSexo());
		usuario.setUsuCodigo(carteiraVO.getUsuCodigo());
		carteira.setUsuario(usuario);
		
		// salvar...
		sessionFactory.getCurrentSession().saveOrUpdate(carteira);
		sessionFactory.getCurrentSession().flush();
	}
	
	/*
	 * (non-Javadoc)
	 * @see br.com.guedes.vacina.facade.CarteiraFacade#excluir(br.com.guedes.vacina.vo.CarteiraVO)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void excluir(CarteiraVO carteiraVO) 
			throws Exception {
//		try {
//			
//		} catch (Exception e) {
//			throw new IntegrationException("Erro ao excluir a carteira.");
//		}
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
