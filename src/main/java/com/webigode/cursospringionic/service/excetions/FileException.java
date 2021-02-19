package com.webigode.cursospringionic.service.excetions;

public class FileException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public FileException(String msg) {
		super(msg);
	}
}
