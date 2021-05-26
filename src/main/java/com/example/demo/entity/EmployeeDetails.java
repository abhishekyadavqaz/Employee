package com.example.demo.entity;

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

import com.example.demo.audit.Audit;
import com.example.demo.audit.Auditable;
import com.example.demo.audit.CustomAudit;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "employees_details")
@EntityListeners(CustomAudit.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class EmployeeDetails implements Auditable {

	public EmployeeDetails(final int id, final int age, final String hobby, final Audit audit) {
		this.id = id;
		this.age = age;
		this.hobby = hobby;
		this.audit = audit;
	}

	@Id
	@Setter
	@Getter
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Setter
	@Getter
	@Column(name = "age")
	private int age;

	@Setter
	@Getter
	@Column(name = "hobby")
	private String hobby;

	@OneToOne(mappedBy = "employeeDetails", fetch = FetchType.LAZY)
	private Employee employee;

	@Setter
	@Getter
	@Embedded
	private Audit audit;

}
// @GeneratedValue(strategy = GenerationType.AUTO)