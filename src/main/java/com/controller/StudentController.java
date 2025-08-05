package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Student;
import com.model.User;
import com.service.StudentService;
import com.service.UserService;

@RestController
@RequestMapping("/stu")
public class StudentController {
	@Autowired
	private StudentService service;

	@GetMapping("/Welcome")
	public String sayWelcome() {

		return "Welcome to Spring Boot";
	}

//	@PostMapping("/login")
//	public String login(@RequestBody User user) {
//		boolean isFound = service.fetchStudent(user.getUserName(), user.getPassword());
//		if (isFound) {
//			return user.getUserName() + " " + "Found";
//		}
//		return "User not found";
//	}

	@PostMapping("/addStudents")
	public String register(@RequestBody Student student) {
		service.addStudent(student);

		return "Student is registered" + student;
	}

	@GetMapping("/fetchstudents")
	public List<Student> Fetchstudents() {

		return service.getAllStudents();
	}
	@GetMapping("/fetchid/{id}")
	public String getStudentfromID(@PathVariable int id) {
		
		if(service.getStudentById(id)) {
			return id+" "+ "found";
			
		}
		return "User not found";
	}
	@DeleteMapping("/deletestudent/{id}")
	public String deleteusers(@PathVariable int id) {
		
		if(service.deleteStudent(id)) {
			return id+" "+ "found and deleted";
			
		}
		return "User not found";
	}
	@PutMapping("/updatestudent/{id}")
	public String updatestudent(@PathVariable int id,@RequestBody Student student) {
		
		if(service.updateStudent(id,student)) {
			return id+" "+ "found and updated";
			
		}
		return "User not found";
	}
}
