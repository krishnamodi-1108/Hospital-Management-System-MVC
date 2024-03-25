package com.model.service;

import java.sql.Date;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Appointment;
import com.bean.Doctor;
import com.bean.Patient;
import com.bean.Schedule;
import com.model.persistence.AppointmentDao;
import com.model.persistence.DoctorDao;
import com.model.persistence.PatientDao;
import com.model.persistence.ScheduleDao;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorDao doctorDao;
	
	@Autowired
	private ScheduleDao scheduleDao;
	
	@Autowired
	private AppointmentDao appointmentDao;
	
	@Override
	public List<Doctor> getAllDoctor() {
		// TODO Auto-generated method stub
		return doctorDao.findAll();
	}

	@Override
	public boolean addDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		Doctor doctor2 = new Doctor();
		doctor2.setDoctorId(setDoctorId());
		doctor2.setDoctorName(doctor.getDoctorName());
		doctor2.setDoctorGender(doctor.getDoctorGender());
		doctor2.setDoctorAge(doctor.getDoctorAge());
		doctor2.setDoctorAddress(doctor.getDoctorAddress());
		doctor2.setDoctorContact(doctor.getDoctorContact());
		doctor2.setDoctorDepartment(doctor.getDoctorDepartment());
		doctor2.setDoctorExperience(doctor.getDoctorExperience());
		
		if(doctorDao.save(doctor2) != null)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteDoctor(String doctorId) {
		// TODO Auto-generated method stub
		Doctor doctor = getDoctorById(doctorId);
		if(doctor != null) {
			doctorDao.deleteById(doctorId);
			return true;
		}
		else
			return false;
	}

	@Override
	public Doctor getDoctorById(String doctorId) {
		// TODO Auto-generated method stub
		Optional<Doctor> doctor = doctorDao.findById(doctorId);
		if(doctor.isPresent()) {
			return doctor.get();
		}else {
			return new Doctor();
		}
	}

	@Override
	public String getLastDoctorId() {
		Doctor doctor = doctorDao.findTopByOrderByDoctorIdDesc();
		return doctor.getDoctorId();
	}

	@Override
	public String setDoctorId() {
		// TODO Auto-generated method stub
		String lastId = getLastDoctorId();
		if(lastId != null) {
			int id = Integer.parseInt(lastId.substring(1));
			id++;
			return ("D"+id);
		}else
			return "D101";
	}
	
	@Override
	public Schedule getDoctorSchedule(String doctorId) {
		
		return scheduleDao.findByDoctorId(doctorId);
	}
	
	@Override
	public List<Appointment> getMyAppointments(String id) {
		return appointmentDao.getAllAppointmentsByDoctorId(id);
	}

	@Override
	public List<Schedule> getAvailableDoctors(Date date) {
		Format f = new SimpleDateFormat("EEEE");  
		String day = f.format(date);
		return scheduleDao.getAvailableDoctors(day);
	}


}
