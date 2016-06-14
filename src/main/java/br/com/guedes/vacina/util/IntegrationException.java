package br.com.guedes.vacina.util;

public class IntegrationException extends Exception {

	private static final long serialVersionUID = -3852773613745279611L;

	public IntegrationException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public IntegrationException(String message) {
		
		super(message);
	}	
	
	public IntegrationException(Throwable cause) {
		
		super(cause);
	}	
}
