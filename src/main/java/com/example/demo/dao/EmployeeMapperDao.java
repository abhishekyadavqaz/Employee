package com.example.demo.dao;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.demo.vo.Employee;
import com.example.demo.vo.EmployeeVo;

@Mapper(componentModel = "spring", uses = EmployeeDetailsMapperDao.class)
public interface EmployeeMapperDao {

	EmployeeVo toVo(Employee emp);

	Employee toEntity(EmployeeVo vo);

	List<EmployeeVo> toVoList(List<Employee> entityList);

	List<Employee> toEntityList(List<EmployeeVo> voList);

}
