package com.gbs.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gbs.entity.User;
import com.gbs.entity.UserResponse;
import com.gbs.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@GetMapping("/usersResponse")
	public UserResponse getAllUserResponse() {
		List<User> usersList = userRepository.findAll();
		UserResponse userResponse = new UserResponse();
		userResponse.setUsers(usersList);
		return userResponse;
	}

	@GetMapping("/userdetails")
	@ResponseBody
	public UserResponse userDetails() {
		List<User> userList = userRepository.findAll();
		UserResponse uResponse = new UserResponse();
		uResponse.setUsers(userList);
		return uResponse;
	}

	@GetMapping("/checking")
	public ResponseEntity<User> loginValidation(@RequestBody User loginFromBrowser) {

		try {
			String userNameLogIn = loginFromBrowser.getUserName();
			String passwordLogIn = loginFromBrowser.getUserPassword();

			List<User> loginList = userRepository.findAll();
			for (User userLogin : loginList) {
				String userNameInList = userLogin.getUserName().toString();
				if (userNameInList.equals(userNameLogIn)) {
					User userNameString = userRepository.findById(userLogin.getUserName()).get();
					String passFoundString = userNameString.getUserPassword().toString();

					if (passFoundString.equals(passwordLogIn)) {
						System.out.println("Log in successful!");
						return null;
					} else
						System.out.println("Log in failed. ");
					return null;
				}
			}
			return null;
		} catch (Exception e) {
			if (e instanceof EntityNotFoundException) {
				System.out.println("Record not found. Login failed. ");
			}
			return null;
		}
	}

	// CREATE A NEW USER
	@PostMapping("/register")
	public User registerUser(@RequestBody User registration) {
		User saveUserDetails = userRepository.save(registration);
		return saveUserDetails;
	}

	// UPDATE EXISTING USER
	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable(value = "id") String userId, @RequestBody User userFromBrowser) {
		System.out.println("Updating : " + userFromBrowser);
//			fetch the product from the database with the id
		User existingUser = userRepository.findById(userId).get();
//			update the existing user with the details from the browser
		existingUser.setUserName(userFromBrowser.getUserName());
		existingUser.setUserPassword(userFromBrowser.getUserPassword());
		existingUser.setCreationDate(userFromBrowser.getCreationDate());
		existingUser.setNumberOfAccounts(userFromBrowser.getNumberOfAccounts());
		existingUser.setListOfAccounts(userFromBrowser.getListOfAccounts());
		existingUser.setTotalBalance(userFromBrowser.getTotalBalance());
		existingUser.setContactNumber(userFromBrowser.getContactNumber());

//			save the updated details
		User updatedUser = userRepository.save(existingUser);
		return updatedUser;
	}

//		DELETE AN EXISTING USER
	@DeleteMapping("/users/{userIdfromBrowser}")
	public void deleteUser(@PathVariable(value = "userIdfromBrowser") String userId) {
		System.out.println("Deleting : " + userId);
		userRepository.deleteById(userId);
	}
}
