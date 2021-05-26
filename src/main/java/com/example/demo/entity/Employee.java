package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
import lombok.ToString;

@AllArgsConstructor
@ToString
@NoArgsConstructor
@Entity
@Setter
@Getter
@Table(name = "employees")
@EntityListeners(CustomAudit.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Employee implements Auditable {

	public Employee(final String firstName, final String lastName, final String email, final int detaild) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.detaild = detaild;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "id")
	private int id;

	@Column(name = "first_Name")
	private String firstName;

	@Column(name = "last_Name")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "employee_details_id")
	private int detaild;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "detaild", referencedColumnName = "id")
	private EmployeeDetails employeeDetails;

	@Embedded
	private Audit audit;

}
