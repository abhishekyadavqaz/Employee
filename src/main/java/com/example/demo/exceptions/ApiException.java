package com.example.demo.exceptions;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class ApiException {

	private final String message;
	private final Throwable Throwable;
	private final HttpStatus httpStatus;
	private final ZonedDateTime timestamp;

	public ApiException(final String message, final java.lang.Throwable throwable, final HttpStatus httpStatus,
			final ZonedDateTime timestamp) {
		this.message = message;
		Throwable = throwable;
		this.httpStatus = httpStatus;
		this.timestamp = timestamp;
	}

}
