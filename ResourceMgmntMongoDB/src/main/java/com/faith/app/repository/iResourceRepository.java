package com.faith.app.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.faith.app.model.Resource;

public interface iResourceRepository extends MongoRepository<Resource, Long> {

	Optional<Resource> findByResourceType(String resourceName);

}
