package com.collegeadmissionapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.collegeadmissionapp.model.EmployeeInformation;
import com.collegeadmissionapp.repository.EmpInfoRepositry;

@RestController
public class EmpInfoController {

	@Autowired
	EmpInfoRepositry empinforepositry;
	
	@PostMapping("details/employeeinfo")
	public EmployeeInformation Information(@RequestBody EmployeeInformation information)
	{
		
		EmployeeInformation apply=empinforepositry.save(information);
		System.out.println(apply.getJoiningdate());
		System.out.println(apply);
		return apply; 
		
	}
	@GetMapping("employeeinformation/listemployee")
	public List<EmployeeInformation> findAllEmployees()
	{
		List<EmployeeInformation> employeelist=empinforepositry.findAll();
		return employeelist ;
	}
}
