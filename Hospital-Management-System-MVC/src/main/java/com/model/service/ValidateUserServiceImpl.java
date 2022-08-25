package com.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Doctor;
import com.bean.Login;
import com.bean.Patient;
import com.model.persistence.DoctorDao;
import com.model.persistence.LoginDao;
import com.model.persistence.PatientDao;

@Service
public class ValidateUserServiceImpl implements ValidateUserService {
	@Autowired
	private LoginDao loginDao;
	
	@Override
	public boolean isValid(String id, String Password) {
		
		Login login =  loginDao.findPasswordById(id);
		if(login == null)
			return false;
		String password = login.getPassword();
		if(Password.equals(password))
			return true;
		return false;
			
	}

	@Override
	public boolean registerUser(String id, String password) {
		if(loginDao.save(new Login(id,password)) != null)
			return true;
		return false;
	}
}
