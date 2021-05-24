package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Response {

	HttpStatus status = HttpStatus.OK;
	String code;
	String message;
	String detail;
	String exception;

}
