package com.collegeadmissionapp.model;

import java.sql.Date;
import java.time.LocalDate;

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
@Table(name="admission")
public class Application {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AutoIncrement
	@Column(name="application_id")
	private Integer applicationId;
	@Column(name="user_id")
	private Integer userId;
	@Column(name="father_name")
	private String fathername;
	@Column(name="mother_name")
	private String mothername;
	@Column(name="dob")
	private Date dob;
	@Column(name="nationality")
	private String nationality;
	@Column(name="gender")
	private String gender;
	@Column(name="sslcboard")
	private String sslcboard ;
	@Column(name="sslc_percentage")
	private Float sslcmark ;
	@Column(name="sslc_yop")
	private Integer sslcyearofpassing;
	@Column(name="hscboard")
	private String hscboard;
	@Column(name="hsc_stream")
	private String hscstream;
	@Column(name="hsc_percentage")
	private Float hscpercentage;
	@Column(name="hsc_yop")
	private Integer hscyearofpassing;
	@Column(name="department")
	private String department;
	@Column(name="appliaction_status")
	private String appliactionstatus;
	@Column(name="address")
	private String address;
	@Column(name="district")
	private String district;
	@Column(name="state")
	private String state;
	
	
	
	
	
	
	
	
}
