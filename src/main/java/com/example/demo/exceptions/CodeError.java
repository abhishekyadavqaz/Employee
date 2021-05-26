package com.example.demo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CodeError implements Code {

	EMPLOYE_NOT_FOUND("No Employee With This Id"), NUMBER_LESS_THEN_ZERO("Number Should Not Be Less Then Zero");

	String message;

	@Override
	public String getCode() {

		return name();
	}

	@Override
	public int getStatusCode() {

		return 200;
	}

}
