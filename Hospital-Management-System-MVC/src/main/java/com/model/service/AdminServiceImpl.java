package com.model.service;

import java.sql.Date;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Doctor;
import com.bean.Patient;
import com.bean.Schedule;
import com.model.persistence.DoctorDao;
import com.model.persistence.PatientDao;
import com.model.persistence.ScheduleDao;
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private DoctorDao doctorDao;
	@Autowired
	private PatientDao patientDao;
	@Autowired
	private PatientService patientService;
	@Autowired
	private ScheduleDao scheduleDao;
	
	@Autowired
	private DoctorService doctorService;

	@Override
	public boolean registerDoctorToDatabase(Doctor doctor) {
		return doctorService.addDoctor(doctor);
	}

	@Override
	public boolean removeDoctorFromDatabase(String doctorID) {
		return doctorService.deleteDoctor(doctorID);
	}
	
	@Override
	public List<Patient> getAllPatient() {
		// TODO Auto-generated method stub
		return patientService.getAllPatient();
	}

	@Override
	public List<Doctor> getAllDoctor() {
		// TODO Auto-generated method stub
		return doctorService.getAllDoctor();
	}

	@Override
	public boolean removePatientFromDatabase(String patientId) {
		// TODO Auto-generated method stub
		return patientService.deletePatient(patientId);
	}

}
