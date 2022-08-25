package com.model.persistence;


import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bean.Schedule;

@Repository
public interface ScheduleDao extends JpaRepository<Schedule,Integer>{
	
//	boolean addDoctorSchedule(Schedule schedule);
	
//	Schedule saveSchedule(Schedule schedule);
	
//	Schedule findScheduleByDoctorId(String doctorId);
	
	Schedule findByDoctorId(String doctorId);
	
	@Modifying
	@Transactional
	@Query(value = "delete from Schedule where doctorId = :doctorId")
	void deleteScheduleByDoctorId(@Param("doctorId") String doctorId);
	
//	@Modifying
//	@Transactional
//	@Query(value="select s from Schedule s where s.availableDay = :date")
//	List<Schedule> getAvailableDoctors(@Param("date") Date date);
	@Modifying
	@Transactional
	@Query(value="select s from Schedule s where s.availableDay = :day")
	List<Schedule> getAvailableDoctors(@Param("day") String day);
	
	
//	boolean removeDoctorSchedule(String doctorId);

//	Schedule getDoctorSchedule(String doctorId);
	

}
