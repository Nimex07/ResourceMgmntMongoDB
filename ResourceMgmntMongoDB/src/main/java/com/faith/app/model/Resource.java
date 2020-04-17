package com.faith.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "resources") // table
public class Resource {

	// instance variable
	@Id
	private Long resourceTypeId;

	private String resourceType;

	public Long getResourceTypeId() {
		return resourceTypeId;
	}

	public void setResourceTypeId(Long resourceTypeId) {
		this.resourceTypeId = resourceTypeId;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

}
