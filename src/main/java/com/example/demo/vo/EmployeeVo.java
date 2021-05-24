package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Setter
@Getter
@NoArgsConstructor
public class EmployeeVo {

	public EmployeeVo(final String firstName, final String lastName, final String email, final String detaild) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.detaild = detaild;
	}

	private int id;

	private String firstName;

	private String lastName;

	private String email;

	private String detaild;

	private EmployeeDetailsVo employeeDetails;
}
