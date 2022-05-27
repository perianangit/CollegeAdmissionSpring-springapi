package com.collegeadmissionapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.collegeadmissionapp.model.User;
import com.collegeadmissionapp.repository.UserRepository;
import com.collegeadmissionapp.service.UserService;

@RestController
public class UserController {
	
	@Autowired
    UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@PostMapping("user/register")
	public ResponseEntity<String> register(@RequestBody User user)
	{
		try
		{
			userService.register(user);
			
			return new ResponseEntity<String>("Success",HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
//	public User register(@RequestBody User user)
//	{
//		
//		User users=userRepository.save(user);
//		return users;
//	}
	@GetMapping("user/delete/{id}")
	public  String delete(@PathVariable("id") Integer id) 
	{	
		String result = null;
		try {
			userRepository.deleteById(id);
			result ="deleted";
		}catch(Exception e){
			result = e.getMessage();
		}
		return result;
	}
	@GetMapping("user/listuser")
	public List<User> findAll()
	{
		List<User> listuser=userRepository.findAll();
		return listuser;
	}
	
	@GetMapping("user/listname")
	public List<String> listapplicantsname()
	{
		List<String> n=userRepository.listname();
		return n;
	}
	
	
	@PutMapping("user/selectdepartment/{id}")
	public void selectdepartment(@PathVariable("id") Integer id,@RequestParam("branch") String branch)
	{
		userRepository.selectdept(id,branch);
	
	}
	
	@PutMapping("user/applicationstatus/{id}")
	public String applicationstatus(@PathVariable("id") Integer id)
	{
		User user=userRepository.fetchmark(id);
		String a=null;
		if(user.getMark()>80)
		{
			userRepository.applicationstatus(id);
			 a=" Application Accepted";
		}
		else
		{
			userRepository.applicationstatusreject(id);
			 a="Application Rejected";
		}
		return a;
	}
	
	
	
}

