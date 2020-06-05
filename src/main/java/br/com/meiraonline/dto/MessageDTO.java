package br.com.meiraonline.dto;

import java.io.Serializable;
import java.util.Date;

public class MessageDTO implements Serializable{
	
	private static final long serialVersionUID = 3974450261688159094L;

	private Date date;
	
	private String status;
	
	private String message;

	public MessageDTO() {
		super();
	}

	public MessageDTO(Date date, String status, String message) {
		super();
		this.date = date;
		this.status = status;
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
