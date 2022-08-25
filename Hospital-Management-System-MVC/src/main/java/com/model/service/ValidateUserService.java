package com.model.service;


import org.springframework.stereotype.Service;

import com.bean.Doctor;
import com.bean.Patient;


@Service
public interface ValidateUserService {
	boolean registerUser(String id, String Password);
	
	boolean isValid(String id, String Password);
	
//	boolean isDoctor(String id, String Password);
	
//	boolean isAdmin(String id, String Password);
	
//	boolean registerPatient(Patient patient);
	
//	boolean registerDoctor(Doctor doctor); // called internally only by admin 
	
}
