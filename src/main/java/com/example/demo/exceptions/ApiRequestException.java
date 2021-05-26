package com.example.demo.exceptions;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApiRequestException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private final Code code;
	private final String errorCode;
	private final Exception exception;

	public ApiRequestException(final Code code, final Exception exception) {
		this.code = code;
		this.errorCode = "";
		this.exception = exception;
	}

	public ApiRequestException(final Code code) {
		this.code = code;
		this.errorCode = "";
		this.exception = new Exception();
	}

}
