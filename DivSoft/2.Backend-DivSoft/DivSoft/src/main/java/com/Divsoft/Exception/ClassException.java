package com.Divsoft.Exception;

public class ClassException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;

	public ClassException(String msg) {
		super(msg);
		
	}
	
	public ClassException(String msg,Throwable causa) {
		super(msg,causa);
		
	}
	
	

} 
