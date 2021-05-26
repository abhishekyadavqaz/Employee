package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import com.example.demo.vo.EmployeeVo;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("")
	public EmployeeVo creatEmployee(@RequestBody final EmployeeVo employeeVo) {

		return employeeService.creatEmployee(employeeVo);
	}

	@PatchMapping("")
	public EmployeeVo updateEmployee(@RequestBody final EmployeeVo employeeVo) {

		return employeeService.updateEmployee(employeeVo);
	}

	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable final int id) {
		return employeeService.deleteEmployee(id);
	}

	@GetMapping("")
	public List<EmployeeVo> displayEmployee() {

		return employeeService.getAllEmployees();
	}

	@GetMapping("/")
	public List<Employee> setOfEmployee(@RequestParam(value = "limit") final int limit,
			@RequestParam(value = "offSet") final int offSet) {

		return employeeService.setOfEmployee(limit, offSet);
	}

	@GetMapping("/name")
	public List<Employee> getByFirstNameAndLastName(@RequestParam(value = "first") final String first,
			@RequestParam(value = "last") final String last) {
		return employeeService.getByFirstAndLast(first, last);
	}
}
