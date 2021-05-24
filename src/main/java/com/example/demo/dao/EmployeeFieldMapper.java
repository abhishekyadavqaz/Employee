package com.example.demo.dao;

import org.mapstruct.BeanMapping;
// EmployeeFieldMapper
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import com.example.demo.vo.Employee;
import com.example.demo.vo.EmployeeVo;

@Component
@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, uses = EmployeeDetailsMapper.class)
public interface EmployeeFieldMapper {

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	Employee copyDtoToEntityExcludeNull(EmployeeVo employeeVo, @MappingTarget Employee employee);

}
