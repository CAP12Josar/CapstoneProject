package com.gbs.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gbs.repository.UserRepository;


public class UserResponse {
	@Autowired
	UserRepository userRepository;
	private List<User> users;
	
	public List<User> getUsers(){
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
}
