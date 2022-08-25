package com.model.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bean.Appointment;
import com.bean.Doctor;
import com.bean.Patient;
import com.bean.Schedule;
@Service
public interface DoctorService {
	
	
	
	List<Doctor> getAllDoctor();
	
	boolean addDoctor(Doctor doctor);
	
	boolean deleteDoctor(String doctorId);

	Doctor getDoctorById(String doctorId);

	String getLastDoctorId();
	
	String setDoctorId();
	
	Schedule getDoctorSchedule(String doctorId);
	
	List<Appointment> getMyAppointments(String id);
	


	List<Schedule> getAvailableDoctors(Date date);
	
//	boolean updatePatientProfile(String doctorId, String patientId, Map<String,String> editList);
//	
//	
//
	
//
//	Patient getPatientProfile(String patientId);
//
//	void displayAvailableDoctors(Date date);
//
//	boolean updateDoctorSchedule(String doctorId, Schedule schedule);
//

}
