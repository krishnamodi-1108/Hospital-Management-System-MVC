package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Doctor {
	@Id
	@Column(name = "doctor_id")
	private String doctorId;
	@Column(name = "name_of_doctor")
	private String doctorName;
	@Column(name = "specialisation")
	private String doctorDepartment;
	@Column(name = "experience")
	private int doctorExperience;
	@Column(name = "gender")
	private String doctorGender;
	@Column(name = "age")
	private int doctorAge;
	@Column(name = "Contact_number")
	private String doctorContact;
	@Column(name = "Address")
	private String doctorAddress;
	public Doctor(String doctorName, String doctorDepartment, int doctorExperience, String doctorGender, int doctorAge,
			String doctorContact, String doctorAddress) {
		super();
		this.doctorName = doctorName;
		this.doctorDepartment = doctorDepartment;
		this.doctorExperience = doctorExperience;
		this.doctorGender = doctorGender;
		this.doctorAge = doctorAge;
		this.doctorContact = doctorContact;
		this.doctorAddress = doctorAddress;
	}
	
	
	

//	public Doctor(String personId, String personName, String Specialization, int experience, String gender, int age, String Contact, String address){
//		super(personId,personName,age,gender,Contact,Specialization);
//		this.experienceInYears = experience;
//		this.address = address;
//				
//	}
//
//	@Override
//	public String toString() {
//		return "Doctor [experienceInYears=" + experienceInYears + ", address=" + address + ", getPersonId()="
//				+ getPersonId() + ", getName()=" + getName() + ", getAge()=" + getAge() + ", getGender()=" + getGender()
//				+ ", getContactNumber()=" + getContactNumber() + ", getDepartment()=" + getDepartment() + "]";
//	}
//
//	public void setCounter(int counter) {
//		this.counter = counter + 1;
//	}
//	
//	public int getCounter() {
//		return counter;
//	}
	
}
