package com.example.demo.mapper;

import org.mapstruct.Mapper;

import com.example.demo.entity.EmployeeDetails;
import com.example.demo.vo.EmployeeDetailsVo;

@Mapper(componentModel = "spring")
public interface EmployeeDetailsMapperDao {

	EmployeeDetailsVo toVo(EmployeeDetails employeeDetails);

	EmployeeDetails toEntity(EmployeeDetailsVo employeeDetailsVo);

}
