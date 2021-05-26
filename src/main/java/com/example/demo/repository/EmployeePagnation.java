package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Repository
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public interface EmployeePagnation extends PagingAndSortingRepository<Employee, Integer> {

	@Override
	Page<Employee> findAll(Pageable pageable);
}
