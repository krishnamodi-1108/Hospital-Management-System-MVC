package com.model.service;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bean.Doctor;
import com.bean.Patient;
import com.bean.Schedule;
@Service
public interface AdminService {

	boolean registerDoctorToDatabase(Doctor doctor); // add this to menu options in admin login


	boolean removeDoctorFromDatabase(String doctorID);
	
	List<Patient> getAllPatient();
	List<Doctor> getAllDoctor();
	
	boolean removePatientFromDatabase(String patientId);

}
