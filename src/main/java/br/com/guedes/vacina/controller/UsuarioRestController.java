package br.com.guedes.vacina.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.guedes.vacina.facade.UsuarioFacade;
import br.com.guedes.vacina.util.BusinessException;
import br.com.guedes.vacina.vo.RetornoJsonVO;
import br.com.guedes.vacina.vo.UsuarioVO;

@RestController
@RequestMapping("/Usuario")
public class UsuarioRestController {
	
	@Autowired
	public UsuarioFacade usuarioFacade;

	/**
	 * 
	 * @param email
	 * @param senha
	 * @return
	 */
	@RequestMapping(value="/EfetuaLogin", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody RetornoJsonVO getUsuarioEfetuaLoginInJSON(
			@RequestHeader(value="usuEmail") String usuEmail, 
			@RequestHeader(value="usuSenha") String usuSenha) {
		
		RetornoJsonVO retornoUsuarioVO = new RetornoJsonVO();
		try {
			UsuarioVO usuarioVO = new UsuarioVO();
			usuarioVO.setUsuEmail(usuEmail);
			usuarioVO.setUsuSenha(usuSenha);
			
			usuarioVO = usuarioFacade.efetuarLogin(usuarioVO);
		} catch (BusinessException businessException) {
			retornoUsuarioVO.setCodigo(998);
			retornoUsuarioVO.setMensagem(businessException.getMessage());
		} catch (Exception e) {
			retornoUsuarioVO.setCodigo(999);
			retornoUsuarioVO.setMensagem("teste");
		}
		return retornoUsuarioVO;
	}
	
	/**
	 * 
	 * @param nome
	 * @param email
	 * @param senha
	 * @return
	 */
	@RequestMapping(value="/Salva", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody RetornoJsonVO getUsuarioCadastroInJSON(
			@RequestHeader(value="usuNome") String usuNome,
			@RequestHeader(value="usuEmail") String usuEmail, 
			@RequestHeader(value="usuSenha") String usuSenha) {
		RetornoJsonVO retornoUsuarioVO = new RetornoJsonVO();
		try {
			UsuarioVO usuarioVO = new UsuarioVO();
			usuarioVO.setUsuNome(usuNome);
			usuarioVO.setUsuEmail(usuEmail);
			usuarioVO.setUsuSenha(usuSenha);
			
			usuarioFacade.salvar(usuarioVO);
		} catch (BusinessException businessException) {
			retornoUsuarioVO.setCodigo(998);
			retornoUsuarioVO.setMensagem(businessException.getMessage());
		} catch (Exception e) {
			retornoUsuarioVO.setCodigo(999);
			retornoUsuarioVO.setMensagem("teste");
		}
		return retornoUsuarioVO;
	}
	
	/**
	 * 
	 * @param email
	 * @return
	 */
	@RequestMapping(value="/EnviaSenha", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody RetornoJsonVO getUsuarioEnviarSenhaInJSON(
			@RequestHeader(value="usuEmail") String usuEmail) {
		RetornoJsonVO retornoUsuarioVO = new RetornoJsonVO();
		try {
			UsuarioVO usuarioVO = usuarioFacade.obterUsuarioPorEmail(usuEmail);
			usuarioFacade.enviarEmail(usuarioVO.getUsuEmail());
		} catch (BusinessException businessException) {
			retornoUsuarioVO.setCodigo(998);
			retornoUsuarioVO.setMensagem("Email informado não existe.");
		} catch (Exception integrationException) {
			retornoUsuarioVO.setCodigo(999);
			retornoUsuarioVO.setMensagem("Não foi possível enviar a senha para o email informado.");
		}
		return retornoUsuarioVO;
	}
}
