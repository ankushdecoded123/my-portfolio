package com.portfolio.ankush.model;

public class WebMessage {
	
	private String pname;
	
	private String email;
	
	private String subject;
	
	private String message;
	
	public WebMessage() {
		super();
	}

	public WebMessage(String pname, String email, String subject, String message) {
		super();
		this.pname = pname;
		this.email = email;
		this.subject = subject;
		this.message = message;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "WebMessage [name=" + pname + ", email=" + email + ", subject=" + subject + ", message=" + message + "]";
	}
	
	

}
