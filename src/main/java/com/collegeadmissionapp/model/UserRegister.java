package com.collegeadmissionapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name="admissionapp_user")
public class UserRegister {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AutoIncrement
	@Column(name="id")
	private Integer id;
	@Column(name="first_name")
	private String firstname;
	@Column(name="last_name")
	private String lastname;
	@Column(name="ROLE")
	private String role;
	@Column(name="contact_number")
	private String mobilenumber;
	@Column(name="user_email")
	private String email;
	@Column(name="user_password")
	private String password;
	@Column(name="confirm_password")
	private String confirmpassword;

}
