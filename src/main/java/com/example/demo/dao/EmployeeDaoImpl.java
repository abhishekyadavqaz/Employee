package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.repository.EmployeeRepository;
import com.example.demo.vo.Employee;
import com.example.demo.vo.EmployeeDetails;
import com.example.demo.vo.EmployeeVo;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeMapperDao employeeMapperDao;

	@Override
	public EmployeeVo insertEmployee(final EmployeeVo employeeVo) {

		final Employee employee = employeeMapperDao.toEntity(employeeVo);

		final Employee savedEmployee = employeeRepository.save(employee);

		return employeeMapperDao.toVo(savedEmployee);
	}

	@Override
	public boolean getEmployeetbyId(final int id) {

		final boolean employee = employeeRepository.existsById(Integer.valueOf(id));

		return employee;
	}

	@Override
	public List<EmployeeVo> getAllEmployee() {

		final List<Employee> employee = employeeRepository.findAll();

		return employeeMapperDao.toVoList(employee);
	}

	@Override
	public EmployeeVo updateEmployee(final EmployeeVo employeeVo) {

		final Employee employee = employeeMapperDao.toEntity(employeeVo);

		final Employee existingEmployee = employeeRepository.findById(Integer.valueOf(employee.getId())).orElse(null);

		if (employee.getFirstName() != null) {
			existingEmployee.setFirstName(employee.getFirstName());
		}

		if (employee.getLastName() != null) {
			existingEmployee.setLastName(employee.getLastName());
		}

		if (employee.getEmail() != null) {
			existingEmployee.setEmail(employee.getEmail());
		}

		final EmployeeDetails employeeDetails = employee.getEmployeeDetails();

		final EmployeeDetails existingEmployeeDetails = existingEmployee.getEmployeeDetails();

		if (employeeDetails.getAge() != 0) {
			existingEmployeeDetails.setAge(employeeDetails.getAge());
		}

		if (employeeDetails.getHobby() != null) {
			existingEmployeeDetails.setHobby(employeeDetails.getHobby());
		}

		existingEmployee.setEmployeeDetails(existingEmployeeDetails);

		final Employee saveEmployee = employeeRepository.save(existingEmployee);

		return employeeMapperDao.toVo(saveEmployee);

	}

	@Override
	public String deleteEmployee(final int employeeId) {

		final boolean isExist = employeeRepository.existsById(Integer.valueOf(employeeId));

		if (isExist) {
			employeeRepository.deleteById(Integer.valueOf(employeeId));
			return "Employee id : " + employeeId + " Removed";
		}
		return "Employee with id : " + employeeId + " is not present";
	}

}
