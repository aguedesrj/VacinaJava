package br.com.guedes.vacina.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.guedes.vacina.facade.CarteiraFacade;
import br.com.guedes.vacina.util.IntegrationException;
import br.com.guedes.vacina.vo.CarteiraVO;
import br.com.guedes.vacina.vo.RetornoJsonVO;

@RestController
@RequestMapping("/Carteira")
public class CarteiraRestController {
	
	@Autowired
	public CarteiraFacade carteiraFacade;

	@RequestMapping(value="/Salva", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody RetornoJsonVO getUsuarioEfetuaLoginInJSON(
			@RequestHeader(value="carCodigo") Integer carCodigo, 
			@RequestHeader(value="carNome") String carNome,
			@RequestHeader(value="carDataNascimento") String carDataNascimento,
			@RequestHeader(value="carSexo") String carSexo,
			@RequestHeader(value="carNotificacao") String carNotificacao,
			@RequestHeader(value="carFoto") String carFoto,
			@RequestHeader(value="usuCodigo") Integer usuCodigo) {
		
		RetornoJsonVO retornoUsuarioVO = new RetornoJsonVO();
		try {
			CarteiraVO carteiraVO = new CarteiraVO();
			carteiraVO.setCarCodigo(carCodigo);
			carteiraVO.setCarNome(carNome);
			carteiraVO.setCarDataNascimento(carDataNascimento);
			carteiraVO.setCarSexo(carSexo);
			carteiraVO.setCarNotificacao(carNotificacao);
			carteiraVO.setCarFoto(carFoto);
			carteiraVO.setUsuCodigo(usuCodigo);
			
			carteiraFacade.salvar(carteiraVO);
		} catch (IntegrationException integrationException) {
			retornoUsuarioVO.setCodigo(999);
			retornoUsuarioVO.setMensagem("Não foi possível salvar a carteira.");
		}
		return retornoUsuarioVO;
	}
	
	@RequestMapping(value="/Remove", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody RetornoJsonVO getUsuarioEfetuaLoginInJSON(
			@RequestHeader(value="carCodigo") Integer carCodigo,
			@RequestHeader(value="usuCodigo") Integer usuCodigo) {
		
		RetornoJsonVO retornoUsuarioVO = new RetornoJsonVO();
		try {
			CarteiraVO carteiraVO = new CarteiraVO();
			carteiraVO.setCarCodigo(carCodigo);
			carteiraVO.setUsuCodigo(usuCodigo);
			
			carteiraFacade.excluir(carteiraVO);
		} catch (IntegrationException integrationException) {
			retornoUsuarioVO.setCodigo(999);
			retornoUsuarioVO.setMensagem("Não foi possível excluir a carteira.");
		}
		return retornoUsuarioVO;
	}
}