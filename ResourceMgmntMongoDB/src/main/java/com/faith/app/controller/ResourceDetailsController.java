package com.faith.app.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.faith.app.model.ResourceDetails;
import com.faith.app.model.Response;
import com.faith.app.service.iResourceDetailsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin
@RestController
@RequestMapping("/")
public class ResourceDetailsController {

	@Autowired
	private iResourceDetailsService resourceDetailsService;

	/*
	 * @PostMapping("resourcedetails") public ResponseEntity<Response>
	 * addResource(@RequestParam("file") MultipartFile file,
	 * 
	 * @RequestParam("resource") String resource) throws JsonMappingException,
	 * JsonProcessingException, IOException {
	 * System.out.println("Original Image Byte Size - " + file.getBytes().length);
	 * ResourceDetails resourceDet = new ObjectMapper().readValue(resource,
	 * ResourceDetails.class); //
	 * resourceDet.setPhoto(compressBytes(file.getBytes()));
	 * resourceDet.setPicturePath(file.getOriginalFilename()); ResourceDetails
	 * resourceDtls = resourceDetailsService.addResource(resourceDet);
	 * 
	 * if (resourceDtls != null) { return new ResponseEntity<Response>(new
	 * Response("resource details saved success"), HttpStatus.OK); } else { return
	 * new ResponseEntity<Response>(new
	 * Response("resource details saved not success"), HttpStatus.BAD_REQUEST); } }
	 */

	// add resourceDetails
	@PostMapping("resourcedetails")
	public ResponseEntity<ResourceDetails> addResource(@RequestBody ResourceDetails resource) {
		return new ResponseEntity<ResourceDetails>(resourceDetailsService.addResource(resource), HttpStatus.OK);
	}

	// edit resourceDetails
	@PutMapping("resourcedetails")
	public ResponseEntity<ResourceDetails> updateResource(@RequestBody ResourceDetails resource) {
		return new ResponseEntity<ResourceDetails>(resourceDetailsService.updateResource(resource), HttpStatus.OK);
	}

	// find resource by i d
	@GetMapping("resourcedetails-id/{resourceId}")
	public ResponseEntity<ResourceDetails> findResourceById(@PathVariable("resourceId") Long resourceId) {

		ResponseEntity<ResourceDetails> response = null;
		ResourceDetails resource = resourceDetailsService.findResourceById(resourceId);
		if (resource == null) {
			response = new ResponseEntity<ResourceDetails>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<ResourceDetails>(resource, HttpStatus.OK);
		}
		return response;
	}

	// search by resourceTypeId
	@GetMapping("resourcedetails-by-typeid/{id}")
	public ResponseEntity<List<ResourceDetails>> searchResourceType(@PathVariable("id") Long id) {
		// method to search by resource type id
		return new ResponseEntity<List<ResourceDetails>>(resourceDetailsService.searchByResTypeId(id), HttpStatus.OK);
	}

	// search for active resources by resourceTypeId
	@GetMapping("resourcedetails-typeid-isactive/{id}")
	public ResponseEntity<List<ResourceDetails>> searchResourceTypeActive(@PathVariable("id") Long id) {
		// method to search by resource type id
		return new ResponseEntity<List<ResourceDetails>>(resourceDetailsService.searchByResTypeActive(id),
				HttpStatus.OK);
	}

	// get all the resource details
	@GetMapping("resourcedetails")
	public ResponseEntity<List<ResourceDetails>> listAllResources() {
		return new ResponseEntity<List<ResourceDetails>>(resourceDetailsService.listAllResource(), HttpStatus.OK);
	}

	// get all the resource details when is active =y
	@GetMapping("resourcedetails-isactive")
	public ResponseEntity<List<ResourceDetails>> listResourcesDetails() {
		return new ResponseEntity<List<ResourceDetails>>(resourceDetailsService.listResourceDetails(), HttpStatus.OK);
	}

}
