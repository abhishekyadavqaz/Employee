package com.example.demo.exceptions;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApiRequestException extends RuntimeException {

	private Code code;
	private String errorCode;
	private Exception exception;

	public ApiRequestException(final Code code, final Exception exception) {
		this.code = code;
		this.exception = exception;
	}

	public ApiRequestException(final Code code) {
		this.code = code;
	}

}
