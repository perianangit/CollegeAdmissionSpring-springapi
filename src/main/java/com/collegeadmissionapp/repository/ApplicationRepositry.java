package com.collegeadmissionapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.collegeadmissionapp.model.Application;


@Repository
public interface ApplicationRepositry extends JpaRepository<Application,Integer> {
	
	

	
	@Transactional(propagation = Propagation.NEVER)
	@Query("select a from Application a WHERE a.applicationId=:id")
    Application findByApplicationId (@Param("id") Integer id);
	
	@Transactional(propagation = Propagation.NEVER)
	@Query("select a from Application a WHERE a.applicationId=:id")
    Application fetchmark(@Param("id") Integer id);
	
	@Transactional
	@Modifying
	@Query("UPDATE Application a SET a.appliactionstatus='accepted' WHERE a.applicationId=:id")
	void applicationstatus(@Param("id") Integer id);
	
	
	@Transactional
	@Modifying
	@Query("UPDATE Application a SET a.appliactionstatus='rejected' WHERE a.applicationId=:id")
	void applicationstatusreject(@Param("id") Integer id);
	
	
	@Transactional(propagation = Propagation.NEVER)
	@Query("select a from Application a WHERE a.userId=:id")
    Application userstatus(@Param("id") Integer id);
	
	@Transactional
	@Modifying
	@Query("UPDATE Application a SET a.department=:department WHERE a.userId=:id")
	void selectdept(@Param("id") Integer id,@Param("department") String department);
	
}
