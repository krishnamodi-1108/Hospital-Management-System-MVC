package com.controller;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Appointment;
import com.bean.Doctor;
import com.bean.Patient;
import com.bean.Schedule;
import com.model.service.AppointmentService;
import com.model.service.DoctorService;
import com.model.service.PatientService;

@Controller
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private AppointmentService appointmentService;
	
//	 Patient Functionalities --------------------------------------------------------------------------------------------------------------------
	

//	1. view patient profile
	@RequestMapping("/showPatient")
	public ModelAndView showPatientController(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		

		Patient patient = patientService.getPatientById((String)session.getAttribute("userName"));
		if (patient != null) {
			modelAndView.addObject("patient", patient);
			modelAndView.setViewName("ShowPatient");
		}
		else {
			String message="Patient with ID "+(String)session.getAttribute("userName")+" does not exist!";
			modelAndView.addObject("message", message);
			modelAndView.setViewName("Output");
		}
		return modelAndView;
	}
	
//	2. request appointment
	@RequestMapping("/requestAppointment")
	public ModelAndView requestAppointmentController() {
			return new ModelAndView("requestAppointmentPage");
	}
	
//	2.1 generate appointment 
	
	
	@RequestMapping("/generateAppointment")
	public ModelAndView generateAppointmentController(HttpServletRequest request, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		Date date = Date.valueOf(request.getParameter("appointmentDate"));
		session.setAttribute("date", date);
		List<Schedule> availableDoctorsSchedule = doctorService.getAvailableDoctors(date);
		if(availableDoctorsSchedule != null) {
			modelAndView.addObject( "availableScheduleList", availableDoctorsSchedule);
			modelAndView.addObject("command3",new Schedule());
			modelAndView.setViewName("ShowAvailableDoctorsSchedulePage");
		}
		else {
			String message="No available Doctor schedules to display";
			modelAndView.addObject("message", message);
			modelAndView.setViewName("Output");
		}
		return modelAndView;
	}
	
//	@ModelAttribute("availableDoctorIds")
	public List<String> getAvailableDoctorIds(HttpSession session){
		List<Schedule> availableDoctorsSchedule = doctorService.getAvailableDoctors(Date.valueOf((String)(session.getAttribute("date"))));
		
		return availableDoctorsSchedule.stream().
				map(Schedule::getDoctorId).
				collect(Collectors.toList());
	}
	
	@RequestMapping("/bookAppointment")
	public ModelAndView bookAppointmentController(@ModelAttribute("command2") Schedule schedule, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		
//		String doctorId = request.getParameter("dId");
		Appointment appointments = appointmentService.requestAppointment((String)session.getAttribute("userName"), schedule.getDoctorId(), (Date)session.getAttribute("date"));
		if(appointments != null) {
			modelAndView.addObject( "myAppointmentList", appointments);
			modelAndView.setViewName("ShowMyAppointments");
		}
		else {
			String message="No appointments to display";
			modelAndView.addObject("message", message);
			modelAndView.setViewName("Output");
		}
		
		return modelAndView;
	}
	
	
	
//	3. cancel appointment
	@RequestMapping("/cancelAppointment")
	public ModelAndView cancelAppointmentController(HttpServletRequest request, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		
		String id = (String)session.getAttribute("userName");
		List<Appointment> appointments = patientService.getMyAppointments(id);
		
		
		if(!appointments.isEmpty()) {
			modelAndView.addObject("appointmentList", appointments);
			modelAndView.setViewName("cancelAppointment");
		}
		else {
			String message="No appointments to delete";
			modelAndView.addObject("message", message);
			modelAndView.setViewName("Output");
		}
		
		return modelAndView;
	}
	
//	3.1
	@RequestMapping("/deleteAppointment")
	public ModelAndView deleteAppointmentController(HttpServletRequest request, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("appointmentId"));

		String message = "";

		if(patientService.cancelAppointmentRequest(id)) {
			message="Appointment with ID "+id+" deleted successfully!";
			
		}else {
			message="Appointment with ID "+id+" does not exist!";
		}
		
		modelAndView.addObject("message", message);
		modelAndView.setViewName("Output");
		return modelAndView;
	}
	
//	4. view all appointments
	@RequestMapping("/viewAllAppointments")
	public ModelAndView viewAllAppointmentsController(HttpServletRequest request, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		
		String id = (String) session.getAttribute("userName");
		List<Appointment> appointments = patientService.getMyAppointments(id);
		
		
		if(!appointments.isEmpty()) {
			modelAndView.addObject( "myAppointmentList", appointments);
			modelAndView.setViewName("ShowMyAppointments");
		}
		else {
			String message="No appointments to display";
			modelAndView.addObject("message", message);
			modelAndView.setViewName("Output");
		}
		
		return modelAndView;
		
	}
	
//	5. reschedule appointment
	@RequestMapping("/rescheduleAppointment")
	public ModelAndView rescheduleAppointmentController(HttpServletRequest request, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		
		String id = (String) session.getAttribute("userName");
		List<Appointment> appointments = patientService.getMyAppointments(id);
		
		
		if(!appointments.isEmpty()) {
			modelAndView.addObject( "appointmentList", appointments);
			modelAndView.setViewName("rescheduleAppointment");
		}
		else {
			String message="No appointments to display";
			modelAndView.addObject("message", message);
			modelAndView.setViewName("Output");
		}
		
		return modelAndView;
		
	}
	
	@RequestMapping("/rescheduleAppointmentTo")
	public ModelAndView rescheduleAppointmentToController(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		
		int aid = Integer.parseInt(request.getParameter("appointmentId"));
		Date appointmentDate =Date.valueOf(request.getParameter("appointmentDate"));
		
		if(patientService.rescheduleAppointment(aid, appointmentDate)) {
			String message="Appointment Rescheduled successfully.";
			modelAndView.addObject("message", message);
			modelAndView.setViewName("Output");
		}else{
			String message="Couldn't reschedule Appointment. Please try again.";
			modelAndView.addObject("message", message);
			modelAndView.setViewName("Output");
		};
		
		return modelAndView;
	}
}
