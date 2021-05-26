package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Employee;
import com.example.demo.exceptions.ApiRequestException;
import com.example.demo.exceptions.CodeError;
import com.example.demo.mapper.EmployeeFieldMapper;
import com.example.demo.mapper.EmployeeMapperDao;
import com.example.demo.repository.EmployeePagnation;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.vo.EmployeeVo;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeMapperDao employeeMapperDao;

	@Autowired
	private EmployeeFieldMapper employeeFieldMapper;

	@Autowired
	EmployeePagnation pagnationRepository;

	@Override
	public EmployeeVo insertEmployee(final EmployeeVo employeeVo) {

		final var employee = employeeMapperDao.toEntity(employeeVo);

		final var savedEmployee = employeeRepository.save(employee);

		return employeeMapperDao.toVo(savedEmployee);
	}

	@Override
	public boolean getEmployeetbyId(final int id) {

		return employeeRepository.existsById(Integer.valueOf(id));
	}

	@Override
	public List<EmployeeVo> getAllEmployee() {

		final List<Employee> employee = employeeRepository.findAll();

		return employeeMapperDao.toVoList(employee);
	}

	@Override
	public EmployeeVo updateEmployee(final EmployeeVo employeeVo) {

		final var employee = employeeMapperDao.toEntity(employeeVo);

		final var existingEmployee = employeeRepository.findById(Integer.valueOf(employee.getId()))
				.orElseThrow(() -> new ApiRequestException(CodeError.EMPLOYE_NOT_FOUND));

		final var employeec = employeeFieldMapper.copyDtoToEntityExcludeNull(employeeVo, existingEmployee);

		final var saveEmployee = employeeRepository.save(employeec);

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

	@Override
	public List<Employee> setOfEmployee(final int offSet, final int limit) {

		final Pageable firstPageWithTwoElements = PageRequest.of(offSet, limit);

		final Page<Employee> allProducts = pagnationRepository.findAll(firstPageWithTwoElements);

		return allProducts.toList();
	}

	@Override
	public List<Employee> getByFirstAndLast(final String firstName, final String LastName) {

		return employeeRepository.findByFirstNameAndLastName(firstName, LastName);
	}

}
