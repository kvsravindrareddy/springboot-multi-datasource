package com.ravindra.exception;

public class ErrorDetails {
	private String msg;
	private String statusCode;
	
	public ErrorDetails()
	{
		
	}
	
	public ErrorDetails(String msg, String statusCode)
	{
		this.msg = msg;
		this.statusCode = statusCode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	
}