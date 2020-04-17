package com.faith.app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.faith.app.model.ResourceDetails;

public interface iResourceDetailsRepo extends MongoRepository<ResourceDetails, Long> {

	// list active resources
	@Query("{isActive:'Y'}")
	List<ResourceDetails> listResourcedetails();

	// search by resourceTypeId
	@Query("{'resource.resourceTypeId' : ?0}")
	public List<ResourceDetails> findByResourceType(Long id);

	// search by resourceTypeId-isactive
	@Query("{'resource.resourceTypeId': ?0, 'isActive': 'Y'}")
	public List<ResourceDetails> findByResourceTypeActive(Long id);

}
