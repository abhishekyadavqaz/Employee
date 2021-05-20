package com.example.demo.exceptions;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ApiExceptionHandler {

	@ExceptionHandler(value = { ApiRequestException.class })
	public ResponseEntity<Object> handleApiRequestException(final ApiRequestException e) {

		final HttpStatus badRequest = HttpStatus.BAD_REQUEST;

		final ApiException apiException = new ApiException(e.getMessage(), e, badRequest,
				ZonedDateTime.now(ZoneId.of("Z")));

		return new ResponseEntity<>(apiException, badRequest);
	}
}
