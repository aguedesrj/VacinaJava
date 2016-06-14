package br.com.guedes.vacina.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.guedes.vacina.facade.UsuarioFacade;
import br.com.guedes.vacina.facade.VacinaFacade;
import br.com.guedes.vacina.util.IntegrationException;
import br.com.guedes.vacina.vo.CarteiraVO;
import br.com.guedes.vacina.vo.RetornoJsonVO;
import br.com.guedes.vacina.vo.UsuarioVO;
import br.com.guedes.vacina.vo.VacinaTomadaVO;

@RestController
@RequestMapping("/VacinaTomada")
public class VacinaRestController {
	
	@Autowired
	public VacinaFacade vacinaFacade;

	@RequestMapping(value="/SalvaVacinaTomada", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody RetornoJsonVO getVacinaSalvaVacinaTomadanInJSON(
			@RequestHeader(value="carCodigo") Integer carCodigo, 
			@RequestHeader(value="varCodigo") Integer varCodigo) {
		
		RetornoJsonVO retornoUsuarioVO = new RetornoJsonVO();
		try {
			VacinaTomadaVO vacinaTomadaVO = new VacinaTomadaVO();
			vacinaTomadaVO.setCarCodigo(carCodigo);
			vacinaTomadaVO.setVarCodigo(varCodigo);
			
			vacinaFacade.salvarVacinaTomada(vacinaTomadaVO);
		} catch (IntegrationException integrationException) {
			retornoUsuarioVO.setCodigo(999);
			retornoUsuarioVO.setMensagem("Não foi possível excluir a carteira.");
		}
		return retornoUsuarioVO;
	}
	
	@RequestMapping(value="/ExcluiVacinaTomada", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody RetornoJsonVO getVacinaExcluiVacinaTomadanInJSON(
			@RequestHeader(value="carCodigo") Integer carCodigo, 
			@RequestHeader(value="varCodigo") Integer varCodigo) {
		
		RetornoJsonVO retornoUsuarioVO = new RetornoJsonVO();
		try {
			VacinaTomadaVO vacinaTomadaVO = new VacinaTomadaVO();
			vacinaTomadaVO.setCarCodigo(carCodigo);
			vacinaTomadaVO.setVarCodigo(varCodigo);
			
			vacinaFacade.excluirVacinaTomada(vacinaTomadaVO);
		} catch (IntegrationException integrationException) {
			retornoUsuarioVO.setCodigo(999);
			retornoUsuarioVO.setMensagem("Não foi possível excluir a carteira.");
		}
		return retornoUsuarioVO;
	}
}
