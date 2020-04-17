package com.faith.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.app.model.Resource;
import com.faith.app.repository.iResourceRepository;

@Service
public class ResourceService implements iResourceService {

	@Autowired
	private iResourceRepository resourceRepo;

	// method to add the resource into table
	@Override
	public Resource addResource(Resource resource) {
		return resourceRepo.save(resource);
	}

	// method to update the resource type
	@Override
	public Resource updateResource(Resource resource) {
		return resourceRepo.save(resource);
	}

	@Override
	public List<Resource> listAllResource() {
		return resourceRepo.findAll();
	}

	@Override
	public Resource findResourceById(Long resourceTypeId) {
		Optional<Resource> findResourceId = resourceRepo.findById(resourceTypeId);
		Resource resource = findResourceId.isPresent() ? findResourceId.get() : null;
		return resource;

	}

	@Override
	public Resource findResourcesByName(String resourceName) {
		Optional<Resource> findResourceName = resourceRepo.findByResourceType(resourceName);
		Resource resource = findResourceName.isPresent() ? findResourceName.get() : null;
		return resource;

	}

}
