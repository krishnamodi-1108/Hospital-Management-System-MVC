package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="patient")
public class Patient{
	@Id
	@Column(name = "patient_id")
	private String patientId;
	@Column(name = "name_of_patient")
	private String patientName;
	@Column(name = "gender")
	private String patientGender;
	@Column(name = "age")
	private int patientAge;
	@Column(name = "Contact_number")
	private String patientContact;
	@Column(name = "Address")
	private String patientAddress;
	@Column(name = "department")
	private String patientSymptoms;
	public Patient(String patientName, String patientGender, int patientAge, String patientContact,
			String patientAddress, String patientSymptoms) {
		super();
		this.patientName = patientName;
		this.patientGender = patientGender;
		this.patientAge = patientAge;
		this.patientContact = patientContact;
		this.patientAddress = patientAddress;
		this.patientSymptoms = patientSymptoms;
	}
	
	

	

}