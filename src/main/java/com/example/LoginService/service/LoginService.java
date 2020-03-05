package com.example.LoginService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LoginService.Dao.LoginRepository;
import com.example.LoginService.Model.Login;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository loginRepository;;

	public Boolean isUserValid(String username,String password) {
		
		List<Login> users=loginRepository.findByUsernameAndPassword(username,password);
		
		System.out.println(users.size());
		
		if(users.size()>0) {
			return true;
		}
		return false;
		
	}
}
