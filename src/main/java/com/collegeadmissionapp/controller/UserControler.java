package com.collegeadmissionapp.controller;

import java.util.List;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.collegeadmissionapp.dto.MessageDTO;
import com.collegeadmissionapp.model.UserRegister;
import com.collegeadmissionapp.repository.UserRegisterRepository;
import com.collegeadmissionapp.service.LoginService;
import com.collegeadmissionapp.service.UserService;


@RestController
public class UserControler {
	@Autowired
    UserRegisterRepository userregisterRepository;
	
	@Autowired
	LoginService loginService;
	
	
	
	@PostMapping("userregister/register")
	public UserRegister register(@RequestBody UserRegister userregister)
	{
		
		UserRegister users=userregisterRepository.save(userregister);
		return users;
	}
	
	@GetMapping("userregister/listuser")
	public List<UserRegister> findAll()
	{
		List<UserRegister> listuser=userregisterRepository.findAll();
		return listuser;
	}
	
	@PostMapping("userregister/login")
	public  ResponseEntity<?> login(@RequestBody UserRegister user)
	{
		UserRegister response = null;
		try {
			response=loginService.login(user.getEmail(),user.getPassword());
			System.out.println(response);
			
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
		catch(Exception e) {
			//e.printStackTrace();
			MessageDTO message = new MessageDTO(e.getMessage());
			return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
		
		
	
	
}
