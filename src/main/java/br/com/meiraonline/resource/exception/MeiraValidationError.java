package br.com.meiraonline.resource.exception;

import java.util.ArrayList;
import java.util.List;

public class MeiraValidationError extends MeiraStandardError {

	private static final long serialVersionUID = -8625000282996182100L;

	private List<MeiraFieldMessage> errors = new ArrayList<MeiraFieldMessage>();

	public MeiraValidationError(Long timestamp, Integer status, String error, String message, String path) {
		super(timestamp, status, error, message, path);
	}

	public List<MeiraFieldMessage> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String messagem) {
		errors.add(new MeiraFieldMessage(fieldName, messagem));
	}
}