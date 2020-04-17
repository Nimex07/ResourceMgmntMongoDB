package com.faith.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faith.app.model.Resource;
import com.faith.app.service.iResourceService;

@CrossOrigin
@RestController
@RequestMapping("/")
public class ResourceController {

	@Autowired
	private iResourceService resourceService;

	// add resource
	@PostMapping("resource")
	public ResponseEntity<Resource> addResource(@RequestBody Resource resource) {
		return new ResponseEntity<Resource>(resourceService.addResource(resource), HttpStatus.OK);
	}

	// view all resources
	@GetMapping("resource")
	public ResponseEntity<List<Resource>> listAllResources() {
		return new ResponseEntity<List<Resource>>(resourceService.listAllResource(), HttpStatus.OK);
	}

	// find resource by id
	@GetMapping("resource/{resourceId}")
	public ResponseEntity<Resource> findResourceById(@PathVariable("resourceId") Long resourceTypeId) {
		ResponseEntity<Resource> response = null;
		Resource resource = resourceService.findResourceById(resourceTypeId);
		if (resource == null) {
			response = new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<Resource>(resource, HttpStatus.OK);
		}
		return response;
	}
	
/*
	// find resource by name
	@GetMapping("resourcebyname/{resourceType}")
	public ResponseEntity<Resource> findResourceByName(@PathVariable("resourceType") String resourceType) {
		ResponseEntity<Resource> response = null;
		Resource resource = resourceService.findResourcesByName(resourceType);
		if (resource == null) {
			response = new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<Resource>(resource, HttpStatus.OK);
		}
		return response;
	}
*/
	// edit resource
	@PutMapping("resource")
	public ResponseEntity<Resource> updateResource(@RequestBody Resource resource) {
		return new ResponseEntity<Resource>(resourceService.updateResource(resource), HttpStatus.OK);
	}

}
