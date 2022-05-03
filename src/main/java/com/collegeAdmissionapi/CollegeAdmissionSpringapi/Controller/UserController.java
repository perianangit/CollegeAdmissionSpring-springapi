package com.collegeAdmissionapi.CollegeAdmissionSpringapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.collegeAdmissionapi.CollegeAdmissionSpringapi.Model.User;
import com.collegeAdmissionapi.CollegeAdmissionSpringapi.Repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
    UserRepository userRepository;
	
	@PostMapping("user/register")
	public User register(@RequestBody User user){
		
		User users=userRepository.save(user);
		return users;
		
	}
}

