package com.example.demo.exceptions;

public class ApiRequestException extends RuntimeException {

	public ApiRequestException(final String message, final Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ApiRequestException(final String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
