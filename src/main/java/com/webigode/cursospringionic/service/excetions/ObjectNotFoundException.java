package com.webigode.cursospringionic.service.excetions;

public class ObjectNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(Object id) {
		super("Object not found. Id: "+ id);
	}

}
