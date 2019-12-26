package com.selsoft.kyurx.exception;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

public class BaseException extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5369188223989971726L;

	private String errorType;
	private String message;
	private int statusCode;

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public BaseException() {
	}

	public BaseException(String errorType, String message, String developerMessage, int statusCode) {
		this.errorType = errorType;
		this.message = message;
		this.statusCode = statusCode;
	}

	public JSONObject toJSON() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		if (this.statusCode > 0) {
			jsonObject.put("statusCode", this.statusCode);
		}
		if (StringUtils.isNotBlank(errorType)) {
			jsonObject.put("errorType", this.errorType);
		}
		if (StringUtils.isNotBlank(message)) {
			jsonObject.put("message", this.message);
		}

		return jsonObject;
	}

	@Override
	public String toString() {
		return toJSON().toString();
	}

}
