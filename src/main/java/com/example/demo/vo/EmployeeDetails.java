package com.example.demo.vo;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "employees_details")
@EntityListeners(CustomAudit.class)
public class EmployeeDetails implements Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "age")
	private int age;

	@Column(name = "hobby")
	private String hobby;

	@OneToOne(mappedBy = "employeeDetails", fetch = FetchType.LAZY)
	private Employee employee;

	@Embedded
	private Audit audit;

}
// @GeneratedValue(strategy = GenerationType.AUTO)