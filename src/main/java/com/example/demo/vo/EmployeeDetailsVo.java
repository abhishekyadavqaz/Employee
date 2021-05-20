package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@NoArgsConstructor
public class EmployeeDetailsVo {

	@Getter
	private int id;

	@Getter
	@Setter
	private int age;

	@Getter
	@Setter
	private String hobby;

}
