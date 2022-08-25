package com.model.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bean.ProcedureAppointment;

public interface ProcedureAppointmentDao extends JpaRepository<ProcedureAppointment, Integer>{

	ProcedureAppointment findTopByOrderByProcedureIdDesc();
}
