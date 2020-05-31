package br.com.meiraonline.resource.exception;

import java.io.Serializable;

public class MeiraFieldMessage implements Serializable {

	private static final long serialVersionUID = 5845115815896573636L;

	private String fieldName;
	
	private String message;
	
	public MeiraFieldMessage() {
	}

	public MeiraFieldMessage(String fieldName, String message) {
		super();
		this.fieldName = fieldName;
		this.message = message;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}