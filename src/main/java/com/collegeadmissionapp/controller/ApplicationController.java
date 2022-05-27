package com.collegeadmissionapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.collegeadmissionapp.model.Application;

import com.collegeadmissionapp.repository.ApplicationRepositry;

@RestController
public class ApplicationController {
	
	@Autowired
    ApplicationRepositry Applicationrepositry;
	
	@PostMapping("application/apply")
	public Application Apply(@RequestBody Application application)
	{
		
		Application apply=Applicationrepositry.save(application);
		System.out.println(apply);
		return apply; 
		
	}
    
	@GetMapping("application/searchby")
	public Application findbyapplication(@RequestParam("application_id") Integer id)
	{
		Application searchbyid=Applicationrepositry.findByApplicationId(id);
		return searchbyid;
	}
	
	@GetMapping("application/applicationstatus")
	public String status(@RequestParam("application_id") Integer id)
	{
		Application application=Applicationrepositry.fetchmark(id);
		String a=null;
		if(application.getHscpercentage()>80)
		{
			Applicationrepositry.applicationstatus(id);
			 a=" Application Accepted";
		}
		else
		{
			Applicationrepositry.applicationstatusreject(id);
			 a="Application Rejected";
		}
		return a;
	}
	
	
	@GetMapping("application/userstatus")
	public String userviewapplicationstatus(@RequestParam("user_id") Integer id)
	{
		Application userstatus=Applicationrepositry.userstatus(id);
		String a= userstatus.getAppliactionstatus();
		return a;
	}
	
	
	@GetMapping("application/listapplicantsdetails")
	public List<Application> findAll()
	{
		List<Application> listapplicants=Applicationrepositry.findAll();
		return listapplicants;
	}
	
	@GetMapping("application/selectdepartment")
	public void selectdepartment(@RequestParam("user_id") Integer id,@RequestParam("department") String department)
	{
		Applicationrepositry.selectdept(id,department);
	
	}
}
