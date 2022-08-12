package com.portfolio.ankush.model;

import java.time.LocalDate;
import java.time.ZoneId;

public class WebMessage {
	
	private String name;
	
	private String email;
	
	private String subject;
	
	private String message;
	
	private String timestamp;
	
	public WebMessage() {
		super();
	}

	public WebMessage(String name, String email, String subject, String message) {
		super();
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.message = message;
		this.timestamp = LocalDate.now(ZoneId.of("GMT+05:30")).toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "WebMessage [name=" + name + ", email=" + email + ", subject=" + subject + ", message=" + message
				+ ", timestamp=" + timestamp + "]";
	}
	
	

}
