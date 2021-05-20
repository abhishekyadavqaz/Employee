package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class EmployeeManagementApplication {

	public static void main(final String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);

	}

}
