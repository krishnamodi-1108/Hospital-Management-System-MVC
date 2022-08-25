package com.model.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Appointment;
import com.bean.Doctor;
import com.bean.Patient;
import com.model.persistence.AppointmentDao;
import com.model.persistence.PatientDao;


@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientDao patientDao;
	@Autowired
	private AppointmentDao appointmentDao;
	@Override
	public List<Patient> getAllPatient() {
		// TODO Auto-generated method stub
		return patientDao.findAll();
	}

	@Override
	public Patient addPatient(Patient patient) {
		
		patient.setPatientId(setNewPatientId());
		
		return patientDao.save(patient);
	}

	@Override
	public boolean deletePatient(String patientId) {
		Patient patient = getPatientById(patientId);
		if(patient != null) {
			patientDao.deleteById(patientId);
			return true;
		}
		else
			return false;
	}

	@Override
	public Patient getPatientById(String patientId) {
		// TODO Auto-generated method stub
		Optional<Patient> patient = patientDao.findById(patientId);
		if(patient.isPresent()) {
			return patient.get();
		}else {
			return new Patient();
		}
	}

	@Override
	public String getLastPatientId() {
		Patient patient = patientDao.findTopByOrderByPatientIdDesc();
		return patient.getPatientId();
	}

	@Override
	public String setNewPatientId() {
		// TODO Auto-generated method stub
		String lastId = getLastPatientId();
		if(lastId != null) {
			int id = Integer.parseInt(lastId.substring(1));
			++id;
			return ("P"+id);
		}else
			return "P101";
	}

//	AppointmentDaoImpl appointmentDaoImpl;
//	PatientDaoImpl patientDaoImpl;
//	
//	@Autowired
//	public void setAppointmentDaoImpl(AppointmentDaoImpl appointmentDaoImpl) {
//		this.appointmentDaoImpl = appointmentDaoImpl;
//	}
//
//	@Autowired
//	public void setPatientDaoImpl(PatientDaoImpl patientDaoImpl) {
//		this.patientDaoImpl = patientDaoImpl;
//	}
//
	@Override
	public boolean rescheduleAppointment(int aid, Date newDate) {
		int rows = appointmentDao.reschedule(aid, newDate);
		if(rows >0)
			return true;
		return false;
	}
//
//	@Override
//	public void getPatientProfile(String id) {
//		Patient patient = patientDaoImpl.getPatientById(id);
//		System.out.println(patient.toString());
//	}
//
//	@Override
//	public int getLastPatientId() {
//		return patientDaoImpl.getLastPId();
//	}
//	
	@Override
	public List<Appointment> getMyAppointments(String pid) {
		return appointmentDao.getAllAppointmentsByPatientId(pid);
	}
//
	
//
	@Override
	public boolean cancelAppointmentRequest(int aid) {
		Optional<Appointment> appointment = appointmentDao.findById(aid);
		if(appointment.isPresent()) {
			appointmentDao.deleteById(aid);
			return true;
		}
		else
			return false;
	}


}
