package com.example.demo.service;

import java.util.List;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.aspect.LogExecutionTime;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.vo.EmployeeVo;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	@LogExecutionTime
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public EmployeeVo creatEmployee(final EmployeeVo employeeVo) {

		return employeeDao.insertEmployee(employeeVo);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public List<EmployeeVo> getAllEmployees() {

		return employeeDao.getAllEmployee();
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public EmployeeVo updateEmployee(final EmployeeVo employeeVo) {

		final int id = employeeVo.getId();

		if (id <= 0) {
			return null;
		}

		final boolean oldEmployee = employeeDao.getEmployeetbyId(employeeVo.getId());
		if (oldEmployee) {

			return employeeDao.updateEmployee(employeeVo);
		}

		return null;
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public String deleteEmployee(final int EmployeeId) {

		return employeeDao.deleteEmployee(EmployeeId);

	}

}
