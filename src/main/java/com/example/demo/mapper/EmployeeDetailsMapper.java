package com.example.demo.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import com.example.demo.entity.EmployeeDetails;
import com.example.demo.vo.EmployeeDetailsVo;

@Component
@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface EmployeeDetailsMapper {

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	EmployeeDetails copyDtoToEntityExcludeNull(EmployeeDetailsVo employeeDetailsVo,
			@MappingTarget EmployeeDetails employeeDetails);
}
