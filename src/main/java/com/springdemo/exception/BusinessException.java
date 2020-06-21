package com.springdemo.exception;

/**
 * 业务异常 
 */
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String code;
	
	public BusinessException() {
		super();
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

	public BusinessException(String code, String message) {
		super(message);
		this.code = code;
	}
	
	public BusinessException(String code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}
	
	
	public String getCode() {
		return code;
	}
	
}