package com.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Doctor;
import com.bean.Patient;
import com.model.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
//  Admin Functionalities Start--------------------------------------------------------------------------------------------------------------------------

	
//  Add Doctor
	@RequestMapping("/addDoctor")
	public ModelAndView addDoctorController() {
		return new ModelAndView("addDoctor");
	}
	@RequestMapping("/saveDoctor")
	public ModelAndView saveDoctorController(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		Doctor doctor = new Doctor();
	
		
		doctor.setDoctorName(request.getParameter("dName"));
		doctor.setDoctorAge(Integer.parseInt(request.getParameter("dAge")));
		doctor.setDoctorGender(request.getParameter("dGender"));
		doctor.setDoctorExperience(Integer.parseInt(request.getParameter("dExperience")));
		doctor.setDoctorContact(request.getParameter("dContact"));
		doctor.setDoctorAddress(request.getParameter("dAddress"));
		doctor.setDoctorDepartment(request.getParameter("dDepartment"));
		
		String message = null;
		if (adminService.registerDoctorToDatabase(doctor))
			message = "Doctor Added Successfully";
		else
			message = "Doctor Addition Failed";

		modelAndView.addObject("message", message);
		modelAndView.setViewName("Output");
		return modelAndView;
	}
	
//  Remove Doctor
	
	@ModelAttribute("doctorIds")
	public List<String> getAllDoctorIds(){
		List<Doctor> doctorList = adminService.getAllDoctor();
		
		return doctorList.stream().
				map(Doctor::getDoctorId).
				collect(Collectors.toList());
	}

	@RequestMapping("/removeDoctorByID")
	public ModelAndView removeDoctorByIdController() {
//<<<<<<< HEAD
//		return new ModelAndView("removeDoctor");
//=======
		ModelAndView modelAndView = new ModelAndView();
		List<Doctor> doctorList = adminService.getAllDoctor();
		String message = null;
		if (doctorList != null) {
			modelAndView.addObject("doctorList", doctorList);
			modelAndView.addObject("command2",new Doctor());
			modelAndView.setViewName("ShowAllDoctorsToRemove");
			return modelAndView;
		}
		else {
			message = "No Doctor to show !";

		modelAndView.addObject("message", message);
		modelAndView.setViewName("Output");
		return modelAndView;
		}
//>>>>>>> branch 'master' of https://github.com/krishna-kusum/HMS-in-Spring-JPA-.git
	}
	@RequestMapping("/removeDoctor")
public ModelAndView removeDoctorController(@ModelAttribute("command2") Doctor doctor) {
		ModelAndView modelAndView = new ModelAndView();
		
		
		String message = null;
		if (adminService.removeDoctorFromDatabase(doctor.getDoctorId()))
			message = "Doctor Removed Successfully";
		else
			message = "Remove Failed";

		modelAndView.addObject("message", message);
		modelAndView.setViewName("Output");
		return modelAndView;
	}
//Show All Doctors	
	@RequestMapping("/showAllDoctors")
	public ModelAndView showAllDoctors() {
		ModelAndView modelAndView = new ModelAndView();
		
		List<Doctor> doctorList = adminService.getAllDoctor();
		String message = null;
		if (doctorList != null) {
			modelAndView.addObject("doctorList", doctorList);
			modelAndView.setViewName("ShowAllDoctors");
			return modelAndView;
		}
		else {
			message = "No Doctor to show !";

		modelAndView.addObject("message", message);
		modelAndView.setViewName("Output");
		return modelAndView;
		}
	}
	
	
//Remove Patient
	
	@ModelAttribute("patientIds")
	public List<String> getAllPatientIds(){
		List<Patient> patientList = adminService.getAllPatient();
		
		return patientList.stream().
				map(Patient::getPatientId).
				collect(Collectors.toList());
	}
	@RequestMapping("/removePatient")
	public ModelAndView removePatientController() {
		ModelAndView modelAndView = new ModelAndView();
		
		List<Patient> patientList = adminService.getAllPatient();
		String message = null;
		if (patientList != null) {
			modelAndView.addObject("patientList", patientList);
			modelAndView.addObject("command",new Patient());
			modelAndView.setViewName("ShowAllPatientToRemove");
			return modelAndView;
		}
		else {
			message = "No Patient to delete !";

		modelAndView.addObject("message", message);
		modelAndView.setViewName("Output");
		return modelAndView;
		}
	}
	
	@RequestMapping("/removePatientMessage")
	public ModelAndView removePatientMessage(@ModelAttribute("command") Patient patient) {
		ModelAndView modelAndView = new ModelAndView();
		String message = null;
		if (adminService.removePatientFromDatabase(patient.getPatientId())) {
			message = "Patient deleted Successfully";
			modelAndView.addObject("message", message);
			modelAndView.setViewName("Output");
			return modelAndView;
		}
		else {
			message = "Patient deletion failed";
			modelAndView.addObject("message", message);
			modelAndView.setViewName("Output");
			return modelAndView;
		}
		
	}
	
	
	
//Show All Patients	
	@RequestMapping("/showAllPatients")
	public ModelAndView showAllPatients() {
		ModelAndView modelAndView = new ModelAndView();
		
		List<Patient> patientList = adminService.getAllPatient();
		String message = null;
		if (patientList != null) {
			modelAndView.addObject("patientList", patientList);
			modelAndView.setViewName("ShowAllPatient");
			return modelAndView;
		}
		else {
			message = "No Patient to show !";

		modelAndView.addObject("message", message);
		modelAndView.setViewName("Output");
		return modelAndView;
		}
	}
	
//  Admin Functionalities End ------------------------------------------------------------------------------------------------------------------------
	
	

}
