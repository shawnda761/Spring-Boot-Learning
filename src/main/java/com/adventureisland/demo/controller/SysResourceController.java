package com.adventureisland.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adventureisland.demo.entity.SysResource;
import com.adventureisland.demo.service.SysResourceService;

@RestController
@RequestMapping("/manage/resource")
public class SysResourceController {

	@Autowired
	SysResourceService resourceService;

	@GetMapping("/get/{method}")
	public List<SysResource> getAllResources(@PathVariable("method") String method,
			@RequestBody(required = false) Object parameter) {
		if (method.equals("all")) {
			return resourceService.getResources();
		} else if (method.equals("code")) {
			return resourceService.getResourcesByCode(parameter.toString());
		} else if (method.equals("name")) {
			return resourceService.getResourcesByName(parameter.toString());
		} else if (method.equals("type")) {
			return resourceService.getResourcesByType(parameter.toString());
		} else if (method.equals("uri")) {
			return resourceService.getResourcesByUri(parameter.toString());
		}
		return null;
	}

	@PostMapping("/add")
	public void addResource(@RequestBody SysResource resource) {
		resourceService.createResource(resource);
	}

	@PutMapping("/update")
	public void updateResource(@RequestBody SysResource resource) {
		resourceService.updateResource(resource);
	}

	@DeleteMapping("/delete")
	public void deleteResource(@RequestBody List<Long> ids) {
		resourceService.removeResource(ids);
	}

}
