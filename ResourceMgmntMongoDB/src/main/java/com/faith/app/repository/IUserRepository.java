package com.faith.app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.faith.app.model.User;

public interface IUserRepository extends MongoRepository<User, Long> {
	
	@Query("{userName: ?0, password: ?1}")
	User findByUsernameAndPassword(String userName, String password);

	@Query("{isActive:'Y'}")
	List<User> listUser();

	@Query("{userName: ?0}")
	User findByUserName(String username);

}
