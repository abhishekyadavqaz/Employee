package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.demo.entity.Employee;
import com.example.demo.vo.EmployeeVo;

@Mapper(componentModel = "spring", uses = EmployeeDetailsMapperDao.class)
public interface EmployeeMapperDao {

	EmployeeVo toVo(Employee emp);

	Employee toEntity(EmployeeVo vo);

	List<EmployeeVo> toVoList(List<Employee> entityList);

	List<Employee> toEntityList(List<EmployeeVo> voList);

}
