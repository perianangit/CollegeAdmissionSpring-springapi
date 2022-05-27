package com.collegeadmissionapp.repository;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.collegeadmissionapp.model.UserRegister;

@Repository
public interface UserRegisterRepository extends JpaRepository<UserRegister,Integer> {
	
	@Query("select r from UserRegister r where r.email=:userEmail")
	UserRegister findByEmail(@Param("userEmail") String userEmail);
//	@Query("select r from UserRegister r where r.email=:userEmail")
//	UserRegister login(String email, String password);
}
