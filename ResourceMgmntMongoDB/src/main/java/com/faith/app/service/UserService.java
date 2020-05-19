package com.faith.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.faith.app.model.Resource;
import com.faith.app.model.User;
import com.faith.app.repository.IUserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserRepository userRepo;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Autowired
	private ISequenceGenerator sequenceGenerator;

	@Override
	public User addUser(User user) {
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		user.setId(sequenceGenerator.generateSequence(User.SEQUENCE_NAME));
		return userRepo.save(user);
	}

	@Override
	public List<User> listUser() {
		return userRepo.listUser();
	}

	@Override
	public User findUser(String userName, String password) {
		return userRepo.findByUsernameAndPassword(userName, password);
	}

	@Override
	public User updateUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public void deleteUser(Long id) {
		userRepo.deleteById(id);

	}

	@Override
	public User findById(Long id) {
		Optional<User> findUserId = userRepo.findById(id);
		User user = findUserId.isPresent() ? findUserId.get() : null;
		return user;
	}

}
