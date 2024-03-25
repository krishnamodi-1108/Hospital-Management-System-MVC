package com.model.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bean.Patient;

@Repository
public interface PatientDao extends JpaRepository<Patient, String>{
	
	

	Patient findTopByOrderByPatientIdDesc();

}