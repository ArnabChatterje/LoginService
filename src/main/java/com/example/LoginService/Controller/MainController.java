package com.example.LoginService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.LoginService.Model.Login;
import com.example.LoginService.Model.User;
import com.example.LoginService.service.LoginService;
import com.example.LoginService.service.UserService;

@RestController
public class MainController {
	
	@Autowired
	LoginService loginService;
	@Autowired
	UserService userService;

	private Boolean isAuthenticated;
	
	@GetMapping(value="/")
	public String root() {
		return "awesome app";
	}
//@CrossOrigin(origins = "*")
	@PostMapping(value="/login")
	public ResponseEntity<User> doLogin(@RequestBody Login credentials) {
		
		String username=credentials.getUsername();
		
		String password=credentials.getPassword();
		
		System.out.println(username+"------"+password);
		
		isAuthenticated=doAuthenticate(username,password);
		
		if(isAuthenticated) {
			User u=userService.getUser(username);
			return (ResponseEntity<User>)ResponseEntity.ok(u);
			
		}
		return  new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
	
	private Boolean doAuthenticate(String username,String password) {
		return loginService.isUserValid(username,password);
		
		
	}
}
