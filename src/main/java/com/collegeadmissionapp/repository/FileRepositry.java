package com.collegeadmissionapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.collegeadmissionapp.model.File;

@Repository
public interface FileRepositry extends JpaRepository<File,Integer>{

}
