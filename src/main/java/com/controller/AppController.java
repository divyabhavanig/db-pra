package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;
import com.service.UserService;

@RestController
@RequestMapping("/db")
@CrossOrigin(origins="*")
public class AppController {
	@Autowired
	private UserService service;

	@GetMapping("/Welcome")
	public String sayWelcome() {

		return "Welcome to Spring Boot";
	}

	@PostMapping("/login")
	public String login(@RequestBody User user) {
		boolean isFound = service.findUser(user.getUserName(), user.getPassword());
		if (isFound) {
//			return user.getUserName() + " " + "Found";
			return "Login Successfull";
		}
		return "User not found";
	}

	@PostMapping("/register")
	public String register(@RequestBody User user) {
		service.addUser(user);

		return "User is registered" + user;
	}

	@GetMapping("/loadusers")
	public List<User> loadusers() {

		return service.loadAll();
	}
	@GetMapping("/findusers/{uname}")
	public String findusers(@PathVariable String uname) {
		
		if(service.searchUser(uname)) {
			return uname+" "+ "found";
			
		}
		return "User not found";
	}
	@DeleteMapping("/deleteusers/{uname}")
	public String deleteusers(@PathVariable String uname) {
		
		if(service.deleteUser(uname)) {
			return uname+" "+ "found and deleted";
			
		}
		return "User not found";
	}
	@PutMapping("/updateusers/{uname}")
	public String updateusers(@PathVariable String uname,@RequestBody User user) {
		
		if(service.UpdateUser(uname,user)) {
			return uname+" "+ "found and deleted";
			
		}
		return "User not found";
	}
}
