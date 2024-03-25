package com.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Appointment;
import com.bean.Doctor;
import com.bean.Patient;
import com.bean.Schedule;
import com.model.persistence.DoctorDao;
import com.model.persistence.PatientDao;
import com.model.service.AdminService;
import com.model.service.AppointmentService;
import com.model.service.DoctorService;
import com.model.service.PatientService;
import com.model.service.PatientServiceImpl;
import com.model.service.ValidateUserService;



@Controller
public class CommonController {
	

	@Autowired
	private PatientDao patientDao;
	@Autowired
	private DoctorDao doctorDao;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private AppointmentService appointmentService;
	
	@RequestMapping("/")
	public ModelAndView homePageController() {
		return new ModelAndView("index");
	}
	@RequestMapping("/register")
	public ModelAndView registerPageController() {
		return new ModelAndView("patientRegister");
	}
	
	@RequestMapping("/beforeLogin")
	public ModelAndView beforeLoginController() {
		return new ModelAndView("beforeLogin");
	}
	@RequestMapping("/login")
	public ModelAndView loginPageController() {
		return new ModelAndView("login");
	}

}
