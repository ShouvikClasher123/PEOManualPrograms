package com.cisco.peo.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * @author amigaura
 *
 */
@Component
public class PEOException extends Exception {
	private static long serialVersionUID = 1L;
	
	private Integer id = -1000;
	private String userId = ExceptionUtils.SYSTEM_ID;
	private String errorCode = ExceptionUtils.SYSTEM_ERROR_CODE;
	private String errorMessage = ExceptionUtils.SYSTEM_ERROR_MESSAGE;
	private Throwable throwable = null; 

	// getters
	public Integer getId() {
		return id;
	}

	public String getUserId() {
		return userId;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	
	public Throwable getThrowable() {
		return throwable;
	}

	public void initialize(String userId, String errorCode, String errorMessage, Throwable throwable) {
		this.userId = userId;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.throwable = throwable;
	}
	
	public Map<String, Object> getErrorResponse() {
		Map<String, Object> map = new HashMap<>();
		map.put("USER Id", userId);
		map.put("ERROR CODE", errorCode);
		map.put("ERROR MESSAGE", errorMessage);
		return map;
	}

}
