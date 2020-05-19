package com.faith.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faith.app.model.User;
import com.faith.app.service.IUserService;

@CrossOrigin
@RestController
@RequestMapping("/")
public class UserController {

	@Autowired
	private IUserService userService;

	// add user
	@PostMapping("user")
	public ResponseEntity<User> addUser(@RequestBody User reserv) {
		return new ResponseEntity<User>(userService.addUser(reserv), HttpStatus.OK);

	}

	// list all users
	@GetMapping("user")
	public ResponseEntity<List<User>> listAllUsers() {
		return new ResponseEntity<List<User>>(userService.listUser(), HttpStatus.OK);
	}

	// edit userdetails
	@PutMapping("user")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.updateUser(user), HttpStatus.OK);
	}

	// get users based on username and password
	@GetMapping("user-login/{username}&{password}")
	public ResponseEntity<User> listUser(@PathVariable("username") String username,
			@PathVariable("password") String password) {

		ResponseEntity<User> response = null;
		User user = userService.findUser(username, password);
		if (user == null) {
			response = new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<User>(user, HttpStatus.OK);
		}
		return response;
	}

	// find resource by i d
	@GetMapping("user-searchbyid/{id}")
	public ResponseEntity<User> findUserById(@PathVariable("id") Long id) {
		System.out.println("searching users");
		ResponseEntity<User> response = null;
		User user = userService.findById(id);
		if (user == null) {
			response = new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<User>(user, HttpStatus.OK);
		}
		return response;
	}

}
