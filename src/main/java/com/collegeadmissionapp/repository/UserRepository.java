package com.collegeadmissionapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.collegeadmissionapp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	

	@Transactional
	@Query("select u.name from User u")
	List<String> listname();
	
	@Transactional
	@Modifying
	@Query("UPDATE User u SET u.branch=:branch WHERE u.id=:id")
	void selectdept(@Param("id") Integer id,@Param("branch") String branch);
	
	@Transactional(propagation = Propagation.NEVER)
	@Query("select u from User u WHERE u.id=:id")
    User fetchmark(@Param("id") Integer id);
	
	@Transactional
	@Modifying
	@Query("UPDATE User u SET u.status='accepted' WHERE u.id=:id")
	void applicationstatus(@Param("id") Integer id);
	
	
	@Transactional
	@Modifying
	@Query("UPDATE User u SET u.status='rejected' WHERE u.id=:id")
	void applicationstatusreject(@Param("id") Integer id);
}
