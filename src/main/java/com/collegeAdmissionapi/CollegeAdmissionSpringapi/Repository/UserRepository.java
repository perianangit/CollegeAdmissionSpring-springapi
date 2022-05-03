package com.collegeAdmissionapi.CollegeAdmissionSpringapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collegeAdmissionapi.CollegeAdmissionSpringapi.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}
