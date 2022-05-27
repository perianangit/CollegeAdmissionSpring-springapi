package com.collegeadmissionapp.validation;

import com.collegeadmissionapp.model.User;

public class UserValidation {

public static void validate(User user) throws Exception {
	if(user.getName().isBlank()||user.getName().isEmpty())
	{
		throw new Exception("Enter a valid NAME");
	}
	else if(user.getRole().isBlank()||user.getRole().isEmpty())
	{
		throw new Exception("Enter a valid ROLE");
	}
	else if(user.getMobilenumber().length()==10)
	{
		char[] mobile=user.getMobilenumber().toCharArray();
		for(int i :mobile)
		{
			if(Character.isAlphabetic(i))
			{
				throw new Exception("Enter a valid Mobile Number");
			}
		}
	}
	else if(user.getAge()<0||user.getAge()>100)
	{
		throw new Exception("Enter a valid age");
	}
	else if(user.getYear()<0||user.getYear()>4)
	{
		throw new Exception("Enter a valid year");
	}
	else if(user.getMark()<0||user.getMark()>100)
	{
		throw new Exception("Enter a valid mark");
	}
	else if(!user.getEmail().contains("@"))
	{
		throw new Exception("Enter Valid EmailId");
	}
	else if(user.getPassword().isBlank()||user.getPassword().isEmpty()||user.getPassword().length()>8)
	{
		throw new Exception("Enter a Valid Password");
	}
	
	
}


}
