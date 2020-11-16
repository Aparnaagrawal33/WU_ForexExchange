package com.alien.thirdparty.models;

public class Error {

	private Integer errorcode;
	private String description;
	
	public Error(){
		
	}
	
	public Error(Integer errorcode, String description) {
		this.errorcode = errorcode;
		this.description = description;
	}

	public Integer getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(Integer errorcode) {
		this.errorcode = errorcode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Error [errorcode=" + errorcode + ", description=" + description + "]";
	}
	
	
	
	
}
