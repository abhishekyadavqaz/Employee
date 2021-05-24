package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(value = { ApiRequestException.class })
	@ResponseBody
	public ResponseEntity<Response> handleApiRequestException(final ApiRequestException exception) {

		final var response = new Response();
		response.setDetail(exception.getCode().getMessage());
		response.setCode(exception.getErrorCode());
		response.setMessage(exception.getCode().getCode());
		response.setException(exception.getException().toString());
		response.setStatus(HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(response, response.getStatus());
	}
}
