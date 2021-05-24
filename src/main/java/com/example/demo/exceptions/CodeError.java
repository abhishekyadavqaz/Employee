package com.example.demo.exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum CodeError implements Code {

	EMPLOYE_NOT_FOUND("No Employee With This Id");

	String message;

	@Override
	public String getCode() {

		return name();
	}

	@Override
	public int getStatusCode() {

		return 200;
	}

	@Override
	public String getMessage() {

		return this.message;
	}

}
