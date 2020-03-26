package com.davesmemo.demo.spring.web.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.davesmemo.demo.spring.web.entity.Resource;

@RestController
public class ResourceController {

	/**
	 * Create a resource
	 * 
	 * @param resource the resource
	 * @return the created resource with http status 201 (created)
	 */
	@PostMapping("/resources")
	public ResponseEntity<Resource> postResource(@RequestBody Resource resource) {
		// TODO save resource
		return new ResponseEntity<>(resource, HttpStatus.CREATED);
	}

	/**
	 * Read a resource
	 * 
	 * @param id the target resource's id
	 * @return the created resource with http status 200 (OK)
	 */
	@GetMapping("/resources/{id}")
	public ResponseEntity<Resource> getOneResource(@PathVariable Long id) {
		// TODO get resource from service layer
		Resource resource = new Resource(id);
		return new ResponseEntity<>(resource, HttpStatus.OK);
	}

	/**
	 * Read all resources
	 * 
	 * @return a list of all resources
	 */
	@GetMapping("/resources")
	public ResponseEntity<List<Resource>> getAllResources() {
		// TODO get resource from service layer
		return new ResponseEntity<>(Arrays.asList(new Resource(), new Resource()), HttpStatus.OK);
	}

	/**
	 * Update or replace a resource
	 * 
	 * @param resource the new resource
	 * @param id       the target resource's id
	 * @return the new resource
	 */
	@PutMapping("/resources/{id}")
	public ResponseEntity<Resource> putResource(@RequestBody Resource resource, @PathVariable Long id) {
		// TODO update or replace the resource
		resource.setId(id);
		return new ResponseEntity<>(resource, HttpStatus.OK);
	}

	/**
	 * Update or modify a resource
	 * 
	 * @param resource the new resource
	 * @param id       the target resource's id
	 * @return the new resource
	 */
	@PatchMapping("/resources/{id}")
	public ResponseEntity<Resource> patchResource(@RequestBody Resource resource, @PathVariable Long id) {
		// TODO update or modify the resource
		resource.setId(id);
		return new ResponseEntity<>(resource, HttpStatus.OK);
	}

	/**
	 * Delete a resource
	 * 
	 * @param id the target resource's id
	 */
	@DeleteMapping("/resources/{id}")
	public ResponseEntity<Object> deleteResource(@PathVariable Long id) {
		// TODO delete the resource
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
