package br.com.guedes.vacina.facade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.guedes.vacina.model.Carteira;
import br.com.guedes.vacina.model.Vacina;
import br.com.guedes.vacina.model.VacinaTomada;
import br.com.guedes.vacina.util.IntegrationException;
import br.com.guedes.vacina.vo.VacinaFaixaEtariaVO;
import br.com.guedes.vacina.vo.VacinaTomadaVO;
import br.com.guedes.vacina.vo.VacinaVO;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
public class VacinaFacadeImpl extends HibernateDaoSupport implements VacinaFacade {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(VacinaFacadeImpl.class);
	
	@Autowired 
    private SessionFactory sessionFactory;
	
	/*
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<VacinaVO> listarTodasVacinas() 
			throws IntegrationException {
		try {
			List<Vacina> lista = (List<Vacina>) getHibernateTemplate().find("from Vacina");
			if (lista != null) {
				List<VacinaVO> listaRetorno = new ArrayList<VacinaVO>();
				for (Vacina vacina: lista) {
					VacinaVO vacinaVO = new VacinaVO();
					VacinaFaixaEtariaVO vacinaFaixaEtariaVO = new VacinaFaixaEtariaVO();
					
					vacinaVO.setVacComentario(vacina.getVacComentario());
					vacinaVO.setVacEsquemaRecomendacao(vacina.getVacEsquemaRecomendacao());
					vacinaVO.setVacFlagRedePublica(vacina.isVacFlagRedePublica());
					vacinaVO.setVacObsRedePublica(vacina.getVacObsRedePublica());
					vacinaVO.setVacFlagRedePrivada(vacina.isVacFlagRedePrivada());
					vacinaVO.setVacObsRedePrivada(vacina.getVacObsRedePrivada());
					vacinaVO.setVacEsquemaRecomendacao(vacina.getVacEsquemaRecomendacao());
					vacinaVO.setVacNaoGestante(vacina.isVacNaoGestante());
					vacinaVO.setVacGestante(vacina.getVacGestante());
					vacinaVO.setVacPuerpera(vacina.getVacPuerpera());
					vacinaVO.setVacQuandoIndicar(vacina.getVacQuandoIndicar());
					vacinaFaixaEtariaVO.setVfeCodigo(vacina.getVacinaFaixaEtaria().getVfeCodigo());
					vacinaVO.setVacinaFaixaEtariaVO(vacinaFaixaEtariaVO);
					
					listaRetorno.add(vacinaVO);
				}
				return listaRetorno;
			}
			return null;
		} catch (Exception e) {
			throw new IntegrationException("Erro ao obter todas as vacinas.");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.guedes.vacina.facade.VacinaFacade#salvarVacinaTomada(br.com.guedes.vacina.vo.VacinaTomadaVO)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void salvarVacinaTomada(VacinaTomadaVO vacinaTomadaVO) 
			throws IntegrationException {
		try {
			VacinaTomada vacinaTomada = new VacinaTomada();
			Carteira carteira = new Carteira();
			Vacina vacina = new Vacina();
			
			carteira.setCarCodigo(vacinaTomadaVO.getCarCodigo());
			vacina.setVarCodigo(vacinaTomadaVO.getVarCodigo());
			vacinaTomada.setCarteira(carteira);
			vacinaTomada.setVacina(vacina);
			
			// salvar...
			sessionFactory.getCurrentSession().saveOrUpdate(vacinaTomada);
			sessionFactory.getCurrentSession().flush();
		} catch (Exception e) {
			throw new IntegrationException("Erro ao salvar a vacina tomada.");
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see br.com.guedes.vacina.facade.VacinaFacade#excluirVacinaTomada(br.com.guedes.vacina.vo.VacinaTomadaVO)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void excluirVacinaTomada(VacinaTomadaVO vacinaTomadaVO) 
			throws IntegrationException {
		try {
			VacinaTomada vacinaTomada = new VacinaTomada();
			Carteira carteira = new Carteira();
			Vacina vacina = new Vacina();
			
			carteira.setCarCodigo(vacinaTomadaVO.getCarCodigo());
			vacina.setVarCodigo(vacinaTomadaVO.getVarCodigo());
			vacinaTomada.setCarteira(carteira);
			vacinaTomada.setVacina(vacina);
			
			// salvar...
			sessionFactory.getCurrentSession().delete(vacinaTomada);
			sessionFactory.getCurrentSession().flush();
		} catch (Exception e) {
			throw new IntegrationException("Erro ao excluir vacina tomada.");
		}
	}
}
