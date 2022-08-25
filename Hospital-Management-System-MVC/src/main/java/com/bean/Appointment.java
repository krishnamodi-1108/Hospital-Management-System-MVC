package com.bean;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="appointments")
public class Appointment {
	@Column(name = "patient_id")
	private String patientId;
	@Column(name = "name_of_patient")
	private String patientName;
	@Column(name = "slot")
	private Time slot;
	@Column(name = "date_of_appointment")
	private Date date;
	@Column(name = "doctor_id")
	private String doctorId;
	@Column(name = "name_of_doctor")
	private String doctorName;
	@Column(name = "department")
	private String department;
	@Id
	@Column(name = "appointment_id")
	private int appointmentId;
	
}
