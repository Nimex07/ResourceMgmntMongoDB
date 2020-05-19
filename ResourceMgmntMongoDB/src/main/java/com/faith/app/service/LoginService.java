package com.faith.app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.faith.app.model.User;
import com.faith.app.repository.IUserRepository;

@Service
public class LoginService implements UserDetailsService {

	@Autowired
	private IUserRepository userRepo;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Autowired
	private ISequenceGenerator sequenceGenerator;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUserName(username);

		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				new ArrayList<>());
	}

	// save
	public User save(User user) {
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		user.setId(sequenceGenerator.generateSequence(User.SEQUENCE_NAME));
		return userRepo.save(user);
	}

	// search by username
	public User findByUsername(String userName) {
		return userRepo.findByUserName(userName);
	}
}
