package com.faith.app.service;

import java.util.List;

import com.faith.app.model.Resource;

public interface iResourceService {

	public Resource addResource(Resource resource);

	public Resource updateResource(Resource resource);

	public List<Resource> listAllResource();

	public Resource findResourceById(Long resourceTypeId);

	public Resource findResourcesByName(String resourceName);

}
