package com.portfolio.ankush.model;

public class Response {

	private String response;
	
	private String message;

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Response(String response, String message) {
		super();
		this.response = response;
		this.message = message;
	}

	public Response() {
		super();
	}
	
	
}
