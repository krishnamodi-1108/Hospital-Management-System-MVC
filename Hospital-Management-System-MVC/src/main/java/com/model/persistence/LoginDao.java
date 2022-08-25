package com.model.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.Login;

@Repository
public interface LoginDao extends JpaRepository<Login, String> {
	
//	boolean registerUser(String id, String password,int priority);
	
	
//	boolean validate(String id, String password,int priority);
	
	Login findPasswordById(String id);
	
	
}