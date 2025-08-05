package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.model.Student;
import com.model.User;

@Service
public class StudentService {
	List<Student> students = new ArrayList<>();
	public void addStudent(Student student) {
		students.add(student);
	}
	public boolean deleteStudent(int id) {
		for (Student us : students) {
			if (id==us.getId()){
				students.remove(us);
				return true;
			}

		}
		return false;
		
	}
	public List<Student> getAllStudents() {
		return students;
	}

	public boolean getStudentById(int id) {
		for (Student us : students) {
			if (id==us.getId()) {
				
				return true;
			}

		}
		return false;
	}
//	public boolean searchUser(String uname) {
//		for (User us : list) {
//			if (uname.equals(us.getUserName())) {
//				return true;
//
//			}
//
//		}
//		return false;
//	}
	public boolean updateStudent(int id,Student student) {
		for (Student us : students) {
			if (id==us.getId()) {
				us.setName(student.getName());
				us.setId(student.getId());
				us.setEmail(student.getEmail());
				us.setAge(student.getAge());
				us.setCourse(student.getCourse());
				return true;
			}

		}
		return false;
		
	}
}
