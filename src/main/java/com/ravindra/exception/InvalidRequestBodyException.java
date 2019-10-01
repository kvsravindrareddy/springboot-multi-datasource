package com.ravindra.exception;


public class InvalidRequestBodyException extends RuntimeException {

	private static final long serialVersionUID = -1027740007894689386L;
	private String msg;
	
	public InvalidRequestBodyException()
	{
		
	}
	
	public InvalidRequestBodyException(String msg)
	{
		this.msg = msg;
	}
	
	@Override
	public String toString()
	{
		return msg;
	}
}