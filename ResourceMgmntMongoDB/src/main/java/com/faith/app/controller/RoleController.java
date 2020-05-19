package com.faith.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faith.app.model.RoleDetails;
import com.faith.app.model.User;
import com.faith.app.service.IRoleDetailsService;

@CrossOrigin
@RestController
@RequestMapping("/")
public class RoleController {

	@Autowired
	IRoleDetailsService roleService;

	// list all roles
	@GetMapping("roledetails")
	public ResponseEntity<List<RoleDetails>> listAllUsers() {
		return new ResponseEntity<List<RoleDetails>>(roleService.listRole(), HttpStatus.OK);
	}

	@PostMapping("roledetails")
	public ResponseEntity<RoleDetails> addRole(@RequestBody RoleDetails roleDetails) {
		return new ResponseEntity<RoleDetails>(roleService.addRole(roleDetails), HttpStatus.OK);
	}

}
