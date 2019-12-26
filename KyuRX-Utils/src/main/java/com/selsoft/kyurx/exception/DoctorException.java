package com.selsoft.kyurx.exception;

import org.json.JSONObject;

public class DoctorException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3929231552876547423L;

	public DoctorException() {
		super();
	}

	public DoctorException(String errorType, String message, String developerMessage, int statusCode) {
		super(errorType, message, developerMessage, statusCode);
	}
	
	@Override
	public JSONObject toJSON() {
		return super.toJSON();
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

}
