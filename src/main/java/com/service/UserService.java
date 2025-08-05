package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.model.User;

@Service
public class UserService {
	List<User> list = new ArrayList<User>();

	public void addUser(User user) {
		list.add(user);
	}
	public boolean deleteUser(String uname) {
		for (User us : list) {
			if (uname.equals(us.getUserName())) {
				list.remove(us);
				return true;
			}

		}
		return false;
		
	}
	public List<User> loadAll() {
		return list;
	}

	public boolean findUser(String uname, String pass) {
		for (User us : list) {
			if (uname.equals(us.getUserName()) && pass.equals(us.getPassword())) {
				return true;

			}

		}
		return false;
	}
	public boolean searchUser(String uname) {
		for (User us : list) {
			if (uname.equals(us.getUserName())) {
				return true;

			}

		}
		return false;
	}
	public boolean UpdateUser(String uname,User user) {
		for (User us : list) {
			if (uname.equals(us.getUserName())) {
				us.setUserName(user.getUserName());
				us.setPassword(user.getPassword());
				us.setEmail(user.getEmail());
				us.setCity(user.getCity());
				return true;
			}

		}
		return false;
		
	}
}
