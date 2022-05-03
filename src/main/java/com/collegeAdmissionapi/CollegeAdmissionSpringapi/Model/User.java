package com.collegeAdmissionapi.CollegeAdmissionSpringapi.Model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity(name="collegeapp_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AutoIncrement
	@Column(name="id")
	private Integer id;
	@Column(name="NAME")
	private String name;
	@Column(name="user_admin")
	private String role;
	@Column(name="user_mobile_number")
	private String mobilenumber;
	@Column(name="user_age")
	private int age;
	@Column(name="user_year_of_study")
	private int year;
	@Column(name="user_mark")
	private BigDecimal mark;
	@Column(name="user_email")
	private String email;
	@Column(name="user_password")
	private String password;
	@Column(name="user_admission_status ")
	private String status;
	@Column(name="user_branch")
	private String branch;
	
	
	

	
	
	
	
}
