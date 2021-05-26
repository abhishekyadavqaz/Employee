package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;
import com.example.demo.vo.EmployeeVo;

public interface EmployeeService {

	EmployeeVo creatEmployee(EmployeeVo employeeVo);

	List<EmployeeVo> getAllEmployees();

	String deleteEmployee(int studentId);

	EmployeeVo updateEmployee(EmployeeVo employeeVo);

	List<Employee> setOfEmployee(int limit, int offset);

	List<Employee> getByFirstAndLast(String firstName, String LastName);

}
