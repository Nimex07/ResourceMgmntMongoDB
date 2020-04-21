package com.faith.app.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.faith.app.model.ResourceDetails;
import com.faith.app.repository.iResourceDetailsRepo;

@Service
public class ResourceDetailsService implements iResourceDetailsService {

	@Autowired
	private iResourceDetailsRepo resourceDetailsRepo;
	
	@Autowired
	private ISequenceGenerator sequenceGenerator;

	// add resource
	@Override
	public ResourceDetails addResource(ResourceDetails resourceDetails) {
		// setting id
		resourceDetails.setResourceId(sequenceGenerator.generateSequence(ResourceDetails.SEQUENCE_NAME));
		return resourceDetailsRepo.save(resourceDetails);
	}

	// update resource
	@Override
	public ResourceDetails updateResource(ResourceDetails resourceDetails) {
		return resourceDetailsRepo.save(resourceDetails);
	}

	// list all resources in DESC order
	@Override
	public List<ResourceDetails> listAllResource() {
		return resourceDetailsRepo.findAll(Sort.by(Sort.Direction.DESC, "resourceId"));
	}

	// search by resource id
	@Override
	public ResourceDetails findResourceById(Long resourceId) {
		Optional<ResourceDetails> findResourceId = resourceDetailsRepo.findById(resourceId);
		ResourceDetails resourceDetails = findResourceId.isPresent() ? findResourceId.get() : null;
		return resourceDetails;
	}

	// list all active resources
	@Override
	public List<ResourceDetails> listResourceDetails() {
		return resourceDetailsRepo.listResourcedetails();
	}

	// search by resourceTypeId
	@Override
	public List<ResourceDetails> searchByResTypeId(Long id) {

		return resourceDetailsRepo.findByResourceType(id);
	}

	// search active resources by resourceTypeId
	@Override
	public List<ResourceDetails> searchByResTypeActive(Long id) {
		return resourceDetailsRepo.findByResourceTypeActive(id);
	}

}
