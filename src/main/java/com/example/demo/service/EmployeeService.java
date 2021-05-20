package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.EmployeeVo;

public interface EmployeeService {

	EmployeeVo creatEmployee(EmployeeVo employeeVo);

	List<EmployeeVo> getAllEmployees();

	String deleteEmployee(int studentId);

	EmployeeVo updateEmployee(EmployeeVo employeeVo);

}
