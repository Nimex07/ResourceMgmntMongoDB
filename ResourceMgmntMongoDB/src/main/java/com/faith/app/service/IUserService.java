package com.faith.app.service;

import java.util.List;

import com.faith.app.model.User;

public interface IUserService {

	public User addUser(User user);

	public List<User> listUser();

	public User findUser(String userName, String password);

	public User updateUser(User user);

	public void deleteUser(Long id);

	public User findById(Long id);

}
