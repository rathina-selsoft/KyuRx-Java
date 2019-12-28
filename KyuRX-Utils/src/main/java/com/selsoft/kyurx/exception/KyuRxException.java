package com.selsoft.kyurx.exception;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

public class KyuRxException extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5369188223989971726L;

	private String errorType;
	private String message;

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

	public KyuRxException() {
	}

	public KyuRxException(String errorType, String message) {
		this.errorType = errorType;
		this.message = message;
	}

	public JSONObject toJSON() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

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
