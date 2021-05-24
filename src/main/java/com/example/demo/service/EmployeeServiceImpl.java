package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.aspect.LogExecutionTime;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.exceptions.ApiRequestException;
import com.example.demo.exceptions.CodeError;
import com.example.demo.vo.EmployeeVo;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	@LogExecutionTime
	// @Transactional(isolation = Isolation.DEFAULT, propagation =
	// Propagation.REQUIRED)
	public EmployeeVo creatEmployee(final EmployeeVo employeeVo) {

		return employeeDao.insertEmployee(employeeVo);
	}

	@Override
	// @Transactional(isolation = Isolation.DEFAULT, propagation =
	// Propagation.REQUIRED)
	public List<EmployeeVo> getAllEmployees() {

		return employeeDao.getAllEmployee();
	}

	@Override
	// @Transactional(readOnly = true)
	public EmployeeVo updateEmployee(final EmployeeVo employeeVo) {

		final int id = employeeVo.getId();

		if (id <= 0) {
			throw new ApiRequestException(CodeError.EMPLOYE_NOT_FOUND);
		}
		final boolean oldEmployee = employeeDao.getEmployeetbyId(employeeVo.getId());
		if (oldEmployee) {

			return employeeDao.updateEmployee(employeeVo);
		}

		throw new ApiRequestException(CodeError.EMPLOYE_NOT_FOUND);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public String deleteEmployee(final int EmployeeId) {

		if (EmployeeId <= 0) {
			throw new ApiRequestException(CodeError.EMPLOYE_NOT_FOUND);
		}

		return employeeDao.deleteEmployee(EmployeeId);

	}

}
