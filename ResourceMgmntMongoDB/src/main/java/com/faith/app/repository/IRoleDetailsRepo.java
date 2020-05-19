package com.faith.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.faith.app.model.RoleDetails;

public interface IRoleDetailsRepo extends MongoRepository<RoleDetails, Integer> {

}
