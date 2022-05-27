package com.collegeadmissionapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegeadmissionapp.model.User;
import com.collegeadmissionapp.repository.UserRepository;
import com.collegeadmissionapp.validation.UserValidation;
@Service
public class UserService {
	@Autowired
    UserRepository userRepository;
	
	
	public void register (User user)throws Exception
	{
		UserValidation.validate(user);
		userRepository.save(user);
		
	}
	
}
