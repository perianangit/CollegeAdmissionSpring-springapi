package com.collegeadmissionapp.validation;

public class emplogValidation {
	public static void logvalidation(String email, String password) throws Exception {
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
