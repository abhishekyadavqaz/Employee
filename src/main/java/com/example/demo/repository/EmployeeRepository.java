package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Integer findByDetaild(int d);

	@Query("SELECT e FROM Employee e WHERE firstName = :firstName AND lastName = :lastName")
	List<Employee> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

}