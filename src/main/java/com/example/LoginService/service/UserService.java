package com.example.LoginService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LoginService.Dao.UserRepository;
import com.example.LoginService.Model.User;
@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public User getUser(int id) {
		return null;
	}
	public User getUser(String name) {
		Optional<User> user=userRepository.findByName(name);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	}
	
	public List<User> getAllUser() {
		return null;
	}
}
