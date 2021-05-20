package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@NoArgsConstructor
public class EmployeeVo {

	public EmployeeVo(final String firstName, final String lastName, final String email, final String detaild) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.detaild = detaild;
	}

	@Setter
	@Getter
	private int id;

	@Getter
	@Setter
	private String firstName;

	@Getter
	@Setter
	private String lastName;

	@Getter
	@Setter
	private String email;

	@Getter
	@Setter
	private String detaild;

	@Getter
	@Setter
	private EmployeeDetailsVo employeeDetails;
}
