package com.collegeadmissionapp.validation;






public class LoginValidation {

	

	public static void validateLoginData(String email, String password) throws Exception {
		if(!(email.contains("@")||email.contains(".com")))
		{
		 throw new Exception("Enter a valid email");	
		}
		else if(password.length()>16)
		{
			throw new Exception("Enter a Valid password");
		}
		
	}

	
		

	

	
}
