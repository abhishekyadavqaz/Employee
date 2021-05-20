package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.EmployeeDetails;

@Repository
public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Integer> {

}
