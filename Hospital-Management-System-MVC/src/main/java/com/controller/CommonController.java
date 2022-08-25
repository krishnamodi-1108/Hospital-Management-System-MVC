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
	
//	@Autowired
//	private ValidateUserService validate;
	
	@Autowired
	private PatientDao patientDao;
	@Autowired
	private DoctorDao doctorDao;
//	@Autowired
//	private AdminService adminService;
	@Autowired
	private DoctorService doctorService;
//	@Autowired
//	private PatientService patientService;
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
	
	
	
	
//  Validation--------------------------------------------------------------------------------------------------------------------------------------
	
	
	
//	
//	@RequestMapping("/validate")
//	public ModelAndView validationController(HttpServletRequest request,HttpSession session) {
//		ModelAndView modelAndView=new ModelAndView();
//		
//		String userName = request.getParameter("user");
//		String password = request.getParameter("pass");
//
//		session.setAttribute("userName", userName);
//		
//		
//		 if(validate.isAdmin(userName, password)) {
//			 if(userName.toUpperCase().charAt(0) == 'A' ) {
//				 
//				 modelAndView.setViewName("adminPostLogin");
//			 }else if(userName.toUpperCase().charAt(0) == 'D' ) {
//				 modelAndView.setViewName("doctorPostLogin");
//			 }else  if(userName.toUpperCase().charAt(0) == 'P' ) {
//				 modelAndView.setViewName("patientPostLogin");
//			 }
//		}else {
//			String message = "Invalid Credentials.";
//			modelAndView.addObject("message",message);
//			modelAndView.setViewName("Output");
//		}
//		
//		
////		if(userName.equalsIgnoreCase("Admin") && password.equalsIgnoreCase("123")) {
////			modelAndView.setViewName("adminPostLogin");
////		}
//		
//		
//		
//		return modelAndView;
//		
//	}
//	
//	
////  Registering Patient--------------------------------------------------------------------------------------------------------------------------------------
//	
//	@RequestMapping("/savePatient")
//	public ModelAndView savePatientController(HttpServletRequest request,HttpSession session) {
//		ModelAndView modelAndView = new ModelAndView();
//		
//		Patient patient = new Patient();
//		patient.setPatientName(request.getParameter("pName"));
//		patient.setPatientAge(Integer.parseInt(request.getParameter("pAge")));
//		patient.setPatientGender(request.getParameter("pGender"));
//		patient.setPatientContact(request.getParameter("pContact"));
//		patient.setPatientAddress(request.getParameter("pAddress"));
//		patient.setPatientSymptoms(request.getParameter("pSymptom"));
//		
//		String message = null;
//		if (patientService.addPatient(patient))
//			message = "Patient Added Successfully";
//		else
//			message = "Patient Addition Failed";
//
//		modelAndView.addObject("message", message);
//		modelAndView.setViewName("Output");
//
//		return modelAndView;
//	}
//	
////  Admin Functionalities Start--------------------------------------------------------------------------------------------------------------------------
//
//	
////  Add Doctor
//	@RequestMapping("/addDoctor")
//	public ModelAndView addDoctorController() {
//		return new ModelAndView("addDoctor");
//	}
//	@RequestMapping("/saveDoctor")
//	public ModelAndView saveDoctorController(HttpServletRequest request) {
//		ModelAndView modelAndView = new ModelAndView();
//		Doctor doctor = new Doctor();
//	
//		
//		doctor.setDoctorName(request.getParameter("dName"));
//		doctor.setDoctorAge(Integer.parseInt(request.getParameter("dAge")));
//		doctor.setDoctorGender(request.getParameter("dGender"));
//		doctor.setDoctorExperience(Integer.parseInt(request.getParameter("dExperience")));
//		doctor.setDoctorContact(request.getParameter("dContact"));
//		doctor.setDoctorAddress(request.getParameter("dAddress"));
//		doctor.setDoctorDepartment(request.getParameter("dDepartment"));
//		
//		String message = null;
//		if (adminService.registerDoctorToDatabase(doctor))
//			message = "Doctor Added Successfully";
//		else
//			message = "Doctor Addition Failed";
//
//		modelAndView.addObject("message", message);
//		modelAndView.setViewName("Output");
//		return modelAndView;
//	}
//	
////  Remove Doctor
//
//	@RequestMapping("/removeDoctorByID")
//	public ModelAndView removeDoctorByIdController() {
//		return new ModelAndView("DoctorIdAccepter");
//	}
//	@RequestMapping("/removeDoctor")
//public ModelAndView removeDoctorController(HttpServletRequest request) {
//		ModelAndView modelAndView = new ModelAndView();
//		
//		String id = request.getParameter("dId");
//		String message = null;
//		if (adminService.removeDoctorFromDatabase(id))
//			message = "Doctor Removed Successfully";
//		else
//			message = "Remove Failed";
//
//		modelAndView.addObject("message", message);
//		modelAndView.setViewName("Output");
//		return modelAndView;
//	}
//	
////  Admin Functionalities End ------------------------------------------------------------------------------------------------------------------------
//	
//	
////  Doctor Functionalities Start ---------------------------------------------------------------------------------------------------------------------
//	
//	@RequestMapping("/viewPatientEnterId")
//	public ModelAndView viewPatientEnterIdController() {
//		return new ModelAndView("PatientEnterId");
//	}
//	@RequestMapping("/viewPatient")
//	public ModelAndView viewPatientController(HttpServletRequest request,HttpSession session) {
//		ModelAndView modelAndView = new ModelAndView();
//		
//
//		Patient patient = patientService.getPatientById(request.getParameter("pId"));
//		if (patient != null) {
//			modelAndView.addObject("patient", patient);
//			modelAndView.setViewName("ShowPatient");
//		}
//		else {
//			String message="Patient with ID "+request.getParameter("pId")+" does not exist!";
//			modelAndView.addObject("message", message);
//			modelAndView.setViewName("Output");
//		}
//		return modelAndView;
//	}
//	
	
	
//	 Patient Functionalities --------------------------------------------------------------------------------------------------------------------
	
//
////	1. view patient profile
//	@RequestMapping("/showPatient")
//	public ModelAndView showPatientController(HttpSession session) {
//		ModelAndView modelAndView = new ModelAndView();
//		
//
//		Patient patient = patientService.getPatientById((String)session.getAttribute("userName"));
//		if (patient != null) {
//			modelAndView.addObject("patient", patient);
//			modelAndView.setViewName("ShowPatient");
//		}
//		else {
//			String message="Patient with ID "+(String)session.getAttribute("userName")+" does not exist!";
//			modelAndView.addObject("message", message);
//			modelAndView.setViewName("Output");
//		}
//		return modelAndView;
//	}
//	
////	2. request appointment
//	@RequestMapping("/requestAppointment")
//	public ModelAndView requestAppointmentController() {
//			return new ModelAndView("requestAppointmentPage");
//	}
//	
////	2.1 generate appointment 
//	@RequestMapping("/generateAppointment")
//	public ModelAndView generateAppointmentController(HttpServletRequest request, HttpSession session) {
//		ModelAndView modelAndView = new ModelAndView();
//		Date date = Date.valueOf(request.getParameter("appointmentDate"));
//		session.setAttribute("date", date);
//		List<Schedule> availableDoctorsSchedule = doctorService.getAvailableDoctors(date);
//		if(availableDoctorsSchedule != null) {
//			modelAndView.addObject( "availableScheduleList", availableDoctorsSchedule);
//			modelAndView.setViewName("ShowAvailableDoctorsSchedulePage");
//		}
//		else {
//			String message="No available schedules to display";
//			modelAndView.addObject("message", message);
//			modelAndView.setViewName("Output");
//		}
//		return modelAndView;
//	}
//	@RequestMapping("/bookAppointment")
//	public ModelAndView bookAppointmentController(HttpServletRequest request, HttpSession session) {
//		ModelAndView modelAndView = new ModelAndView();
//		
//		String doctorId = request.getParameter("dId");
//		Appointment appointments = appointmentService.requestAppointment((String)session.getAttribute("userName"), doctorId, (Date)session.getAttribute("date"));
//		if(appointments != null) {
//			modelAndView.addObject( "myAppointmentList", appointments);
//			modelAndView.setViewName("ShowMyAppointments");
//		}
//		else {
//			String message="No appointments to display";
//			modelAndView.addObject("message", message);
//			modelAndView.setViewName("Output");
//		}
//		
//		return modelAndView;
//	}
//	
//	
//	
////	3. cancel appointment
//	@RequestMapping("/cancelAppointment")
//	public ModelAndView cancelAppointmentController(HttpServletRequest request, HttpSession session) {
//		ModelAndView modelAndView = new ModelAndView();
//		
//		String id = (String)session.getAttribute("userName");
//		List<Appointment> appointments = patientService.getMyAppointments(id);
//		
//		
//		if(!appointments.isEmpty()) {
//			modelAndView.addObject("appointmentList", appointments);
//			modelAndView.setViewName("cancelAppointment");
//		}
//		else {
//			String message="No appointments to delete";
//			modelAndView.addObject("message", message);
//			modelAndView.setViewName("Output");
//		}
//		
//		return modelAndView;
//	}
//	
////	3.1
//	@RequestMapping("/deleteAppointment")
//	public ModelAndView deleteAppointmentController(HttpServletRequest request, HttpSession session) {
//		ModelAndView modelAndView = new ModelAndView();
//		int id = Integer.parseInt(request.getParameter("appointmentId"));
//
//		String message = "";
//
//		if(patientService.cancelAppointmentRequest(id)) {
//			message="Appointment with ID "+id+" deleted successfully!";
//			
//		}else {
//			message="Appointment with ID "+id+" does not exist!";
//		}
//		
//		modelAndView.addObject("message", message);
//		modelAndView.setViewName("Output");
//		return modelAndView;
//	}
//	
////	4. view all appointments
//	@RequestMapping("/viewAllAppointments")
//	public ModelAndView viewAllAppointmentsController(HttpServletRequest request, HttpSession session) {
//		ModelAndView modelAndView = new ModelAndView();
//		
//		String id = (String) session.getAttribute("userName");
//		List<Appointment> appointments = patientService.getMyAppointments(id);
//		
//		
//		if(!appointments.isEmpty()) {
//			modelAndView.addObject( "myAppointmentList", appointments);
//			modelAndView.setViewName("ShowMyAppointments");
//		}
//		else {
//			String message="No appointments to display";
//			modelAndView.addObject("message", message);
//			modelAndView.setViewName("Output");
//		}
//		
//		return modelAndView;
//		
//	}
//	
//	@RequestMapping("/rescheduleAppointment")
//	public ModelAndView rescheduleAppointmentController(HttpServletRequest request, HttpSession session) {
//		ModelAndView modelAndView = new ModelAndView();
//		
//		String id = (String) session.getAttribute("userName");
//		List<Appointment> appointments = patientService.getMyAppointments(id);
//		
//		
//		if(!appointments.isEmpty()) {
//			modelAndView.addObject( "appointmentList", appointments);
//			modelAndView.setViewName("rescheduleAppointment");
//		}
//		else {
//			String message="No appointments to display";
//			modelAndView.addObject("message", message);
//			modelAndView.setViewName("Output");
//		}
//		
//		return modelAndView;
//		
//	}
//	
//	@RequestMapping("/rescheduleAppointmentTo")
//	public ModelAndView rescheduleAppointmentToController(HttpServletRequest request) {
//		ModelAndView modelAndView = new ModelAndView();
//		
//		int aid = Integer.parseInt(request.getParameter("appointmentId"));
//		Date appointmentDate =Date.valueOf(request.getParameter("appointmentDate"));
//		
//		if(patientService.rescheduleAppointment(aid, appointmentDate)) {
//			String message="Appointment Rescheduled successfully.";
//			modelAndView.addObject("message", message);
//			modelAndView.setViewName("Output");
//		}else{
//			String message="Couldn't reschedule Appointment. Please try again.";
//			modelAndView.addObject("message", message);
//			modelAndView.setViewName("Output");
//		};
//		
//		return modelAndView;
//	}
	
//	List<String> allAppointments = patientService.getMyAppointments(id, 1);
//	if(allAppointments.isEmpty()) {
//		System.out.println("No appointments requested.");
//		break;
//	}
//	else {
//		System.out.println("Displaying all appointments: ");
//		for(String appointment: allAppointments)
//			System.out.println(appointment);
//	}
//	System.out.println("Enter appointment id for rescheduling: ");
//	int aid = sc.nextInt();
//	System.out.println("Enter new date of appointment");
//	date = Date.valueOf(str.next());
//	LocalDate todays = LocalDate.now();
//	if(date.toString().compareTo(todays.toString()) <= 0) {
//		System.out.println("Entered date is invalid!!");
//		break;
//	}
//	if(patientService.rescheduleAppointment(aid, date))
//		System.out.println("Appointment rescheduled");
//	else
//		System.out.println("Error occured. Please try again later!!");
	


}
