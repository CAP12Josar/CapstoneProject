package com.gbs.stub;

import java.util.List;

import gom.gbs.model.User;



public class UserResponse {
	
	private List<User> users;
	
	public List<User> getUsers(){
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
}
