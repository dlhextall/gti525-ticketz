package ca.etsmtl.ticketz.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.etsmtl.ticketz.controller.HomeController;

public class ShowNotFoundException extends Exception {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private String message;
	
	
	public ShowNotFoundException() {
		this("");
	}
	public ShowNotFoundException(String _message) {
		logger.warn("Page not found (" + _message + ")");
		message = _message;
	}
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String _message) {
		message = _message;
	}
	
}
