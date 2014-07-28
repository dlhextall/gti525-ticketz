package ca.etsmtl.ticketz.exceptions;

public class ShowNotFoundException extends Exception {
	
	private String message;
	
	
	public ShowNotFoundException() {
		this("");
	}
	public ShowNotFoundException(String _message) {
		message = _message;
	}
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String _message) {
		message = _message;
	}
	
}
