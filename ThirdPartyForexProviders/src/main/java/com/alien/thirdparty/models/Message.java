package com.alien.thirdparty.models;

public class Message {
	
	private  boolean success;
	private Error error;
	public Message(boolean success, Error error) {
		super();
		this.success = success;
		this.error = error;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Error getError() {
		return error;
	}
	public void setError(Error error) {
		this.error = error;
	}
	
	

}
