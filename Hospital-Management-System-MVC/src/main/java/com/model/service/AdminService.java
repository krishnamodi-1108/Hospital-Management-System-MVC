package com.model.service;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bean.Doctor;
import com.bean.Patient;
import com.bean.Schedule;
@Service
public interface AdminService {

//	boolean generateAppointment(String patientId); 
	//consists the functionality where in patient
	//	details get matched with available doctor's details
	
//	boolean cancelAppointment(String patientId);
	
//	boolean addPatient(String doctorId,String patientId); //maps a doctor to a patient
//	
//	boolean removePatient(String doctorId,String patientId);
	
	boolean registerDoctorToDatabase(Doctor doctor); // add this to menu options in admin login
	
//	List<Schedule> getAvailableDoctors(Date date);

	boolean removeDoctorFromDatabase(String doctorID);
	
	List<Patient> getAllPatient();
	List<Doctor> getAllDoctor();
	
	boolean removePatientFromDatabase(String patientId);
	
//	boolean displayAvailableDoctors(); //doctor list + emergencyContact
	//add patient, and remove patient
//	multiple patients can be mapped to one doctor
}
