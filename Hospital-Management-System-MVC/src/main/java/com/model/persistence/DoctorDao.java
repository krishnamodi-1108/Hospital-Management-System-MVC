package com.model.persistence;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bean.Doctor;
import com.bean.Patient;
import com.bean.Schedule;

@Repository
public interface DoctorDao extends JpaRepository<Doctor, String>{

//	@Query("SELECT d FROM Doctor d ORDER BY d.doctorId DESC LIMIT 1")
//	Doctor getLastDoctorDetails();
	
	Doctor findTopByOrderByDoctorIdDesc();
	
//	String searchDoctorId(String doctorName);
//	
//	List<Doctor> getDoctorList();
//	
//	boolean addDoctor(Doctor doctor); //return type changed
//	
//	boolean removeDoctor(String doctorId);
//	
//	List<Schedule> getAvailableDoctors(Date date);
//
////	String getEmergencyContact(String doctorId);
//
//	Doctor getDoctorDetails(String doctorId);
//
//	int getLastDId();
}
