package com.collegeadmissionapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.collegeadmissionapp.model.EmployeeInformation;

@Repository
public interface EmpInfoRepositry extends JpaRepository<EmployeeInformation,Integer> {
	

}
