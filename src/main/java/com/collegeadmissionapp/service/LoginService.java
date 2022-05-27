package com.collegeadmissionapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegeadmissionapp.model.UserRegister;
import com.collegeadmissionapp.repository.UserRegisterRepository;
import com.collegeadmissionapp.validation.LoginValidation;
import com.collegeadmissionapp.validation.loginValidation;

@Service
public class LoginService {

	
	
	@Autowired
	UserRegisterRepository userRepositry;
	
	public UserRegister login(String email, String password) throws Exception {
		LoginValidation.validateLoginData(email, password);
		UserRegister user = null;
		try {
			user = userRepositry.findByEmail(email);
			if(user == null) {
				System.out.println("Unregistered User");
				throw new Exception("Not a Registered User");
			}
			else if(user.getPassword().equals(password)) {
				System.out.println(user.getFirstname()+user.getLastname()+" LoggedIn sucessfully");
				return user;
			}
			else {
				throw new Exception("Invalid credentials");
			}
		}
		catch (Exception e) 
		{
			throw new Exception(e.getMessage());
		}
	}
	

	
		
	
	
	
	
	
}
