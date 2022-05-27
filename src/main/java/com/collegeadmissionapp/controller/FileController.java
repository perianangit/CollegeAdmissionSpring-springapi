package com.collegeadmissionapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.collegeadmissionapp.dto.MessageDTO;
import com.collegeadmissionapp.model.File;
import com.collegeadmissionapp.repository.FileRepositry;

@RestController
public class FileController {
	
	@Autowired
	FileRepositry filerepositry;

	 @PostMapping("file/upload")
	  public ResponseEntity<?> uploadFile(@RequestBody File file) {
	   
	    try {
	    	File upload=filerepositry.save(file); 
	    	

	    	//uploadfile = "Uploaded the file successfully: " + file.getDocName();
	      return new ResponseEntity<>(upload,HttpStatus.OK);
	    } catch (Exception e) {
	    	//uploadfile = "Could not upload the file: " + file.getDocName() + "!";
	      MessageDTO message = new MessageDTO(e.getMessage());
			return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
	    }
	  }
}
