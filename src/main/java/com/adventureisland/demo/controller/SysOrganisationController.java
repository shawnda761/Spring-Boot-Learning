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

import com.adventureisland.demo.entity.SysOrganisation;
import com.adventureisland.demo.service.SysOrganisationService;

@RestController
@RequestMapping("/manage/organisation")
public class SysOrganisationController {

	@Autowired
	SysOrganisationService organisationService;

	@GetMapping("/get/{method}")
	public List<SysOrganisation> getAllOrganisations(@PathVariable("method") String method,
			@RequestBody(required = false) Object parameter) {
		if (method.equals("all")) {
			return organisationService.getOrganisations();
		} else if (method.equals("code")) {
			return organisationService.getOrganisationsByCode(parameter.toString());
		} else if (method.equals("name")) {
			return organisationService.getOrganisationsByName(parameter.toString());
		}
		return null;
	}

	@PostMapping("/add")
	public void addOrganisation(@RequestBody SysOrganisation organisation) {
		organisationService.createOrganisation(organisation);
	}

	@PutMapping("/update")
	public void updateOrganisation(@RequestBody SysOrganisation organisation) {
		organisationService.updateOrganisation(organisation);
	}

	@DeleteMapping("/delete")
	public void deleteOrganisation(@RequestBody List<Long> ids) {
		organisationService.removeOrganisation(ids);
	}

}
