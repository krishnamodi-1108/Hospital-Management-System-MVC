package com.model.persistence;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bean.Doctor;
import com.bean.Patient;
import com.bean.Schedule;

@Repository
public interface DoctorDao extends JpaRepository<Doctor, String>{

	Doctor findTopByOrderByDoctorIdDesc();

}
