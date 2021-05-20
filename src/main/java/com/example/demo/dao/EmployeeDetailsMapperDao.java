package com.example.demo.dao;

import org.mapstruct.Mapper;

import com.example.demo.vo.EmployeeDetails;
import com.example.demo.vo.EmployeeDetailsVo;

@Mapper(componentModel = "spring")
public interface EmployeeDetailsMapperDao {

	EmployeeDetailsVo toVo(EmployeeDetails employeeDetails);

	EmployeeDetails toEntity(EmployeeDetailsVo employeeDetailsVo);

}
