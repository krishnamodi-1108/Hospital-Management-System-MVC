package com.model.service;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bean.Appointment;
import com.bean.Patient;
import com.bean.PrevSlots;
@Service
public interface AppointmentService {
//	List<PrevSlots> prevSlots(String dId);
	Appointment requestAppointment(String id, String doc_id, Date date);
	
}
