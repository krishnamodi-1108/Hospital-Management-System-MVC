package com.model.persistence;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bean.Appointment;
import com.bean.Doctor;

@Repository
public interface AppointmentDao extends JpaRepository<Appointment, Integer>{
	
	@Query("Select a from Appointment a where doctor_Id = :doctorId")
	List<Appointment> getAllAppointmentsByDoctorId(@Param("doctorId")String id);
	
	@Query("Select a from Appointment a where patient_Id = :patientId")
	List<Appointment> getAllAppointmentsByPatientId(@Param("patientId")String id);
	
	@Modifying
	@Transactional
	@Query(value = "CALL BOOK_APPOINTMENT(:pId,:dId);", nativeQuery = true)
	int callProcedure(@Param("pId") String pId,@Param("dId") String dId);
	
	List<Appointment> findAppointmentByDoctorIdAndDate(String doctorId, Date date);
	
	Appointment findTopByOrderByAppointmentIdDesc();


	@Modifying
	@Transactional
	@Query("update Appointment set date = :newDate where appointmentId=:aid")
	int reschedule(@Param("aid")int aid,@Param("newDate") Date newDate);

}
