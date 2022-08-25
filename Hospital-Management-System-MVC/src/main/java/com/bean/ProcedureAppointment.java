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
@Table(name="procedureappointment")
public class ProcedureAppointment {
	@Id
	@Column(name="Procedure_Id")
	private int procedureId;
	@Column(name="Patient_id")
	private String pId;
	@Column(name="Patient_Name")
	private String pName;
	@Column(name="Starting_Time")
	private Time startSlot;
	@Column(name="Ending_Time")
	private Time endSlot;
	@Column(name="Doctor_id")
	private String dId;
	@Column(name="Doctor_Name")
	private String dName;
	@Column(name="Department")
	private String dept;
}
