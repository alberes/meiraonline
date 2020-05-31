package br.com.meiraonline.exception;

public class MeiraOnlineObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2081785210558795025L;

	public MeiraOnlineObjectNotFoundException(String msg) {
		super(msg);
	}
	
	public MeiraOnlineObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}

}