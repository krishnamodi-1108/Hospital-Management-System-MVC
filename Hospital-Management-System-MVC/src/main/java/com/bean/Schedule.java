package com.bean;

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
@Table(name="regular_schedule")
public class Schedule {
	
	@Id
	@Column(name = "schedule_id")
	private int scheduleId;
	@Column(name = "doctor_id")
	private String doctorId;
	@Column(name = "name_of_doctor")
	private String nameOfDoctor;
	@Column(name = "available_day")
	private String availableDay;
	@Column(name = "slot_start")
	private Time slotStart;
	@Column(name = "slot_end")
	private Time slotEnd;

}
