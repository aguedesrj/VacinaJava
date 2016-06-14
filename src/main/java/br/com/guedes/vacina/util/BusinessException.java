package br.com.guedes.vacina.util;

public class BusinessException extends Exception {

	private static final long serialVersionUID = -6842916795277414182L;

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public BusinessException(String message) {
		
		super(message);
	}	
	
	public BusinessException(Throwable cause) {
		
		super(cause);
	}	
}
