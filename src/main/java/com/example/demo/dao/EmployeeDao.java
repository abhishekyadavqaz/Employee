package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Employee;
import com.example.demo.vo.EmployeeVo;

public interface EmployeeDao {

	EmployeeVo insertEmployee(EmployeeVo employeeVo);

	boolean getEmployeetbyId(int id);

	List<EmployeeVo> getAllEmployee();

	EmployeeVo updateEmployee(EmployeeVo employeeVo);

	String deleteEmployee(int employeeId);

	List<Employee> setOfEmployee(int limit, int offset);

	List<Employee> getByFirstAndLast(String firstName, String LastName);

}