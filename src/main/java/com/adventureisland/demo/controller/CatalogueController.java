package com.adventureisland.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adventureisland.demo.model.Catalogue;
import com.adventureisland.demo.service.CatalogueService;
import com.adventureisland.demo.util.ResultWrapper;

@RestController
public class CatalogueController {

	@Autowired
	CatalogueService catalogueService;

	@GetMapping("/catalogue/all")
	public ResultWrapper<Catalogue> getAllCatalogues() {
		List<Catalogue> catalogueList = catalogueService.getAllCatalogues();
		return new ResultWrapper<Catalogue>((catalogueList != null && catalogueList.size() > 0), ("Get all catalogues"),
				catalogueList);
	}

	@GetMapping("/catalogue/{id}")
	public ResultWrapper<Catalogue> getCatalogueById(@PathVariable("id") Long id) {
		List<Catalogue> singleCatalogue = catalogueService.getCatalogue(id);
		return new ResultWrapper<Catalogue>((singleCatalogue != null && singleCatalogue.size() > 0),
				("Get catalogues " + id), singleCatalogue);
	}

	@PostMapping("/catalogue/add")
	public ResultWrapper<Catalogue> addCatalogue(@RequestBody Catalogue catalogue) {
		return new ResultWrapper<Catalogue>(catalogueService.addCatalogue(catalogue), "Add new catalogue",
				catalogueService.getAllCatalogues());
	}

	@PutMapping("/catalogue/update")
	public ResultWrapper<Catalogue> updateCatalogue(@RequestBody Catalogue catalogue) {
		return new ResultWrapper<Catalogue>(catalogueService.updateCatalogue(catalogue),
				"Update catalogue " + catalogue.getId(), catalogueService.getAllCatalogues());
	}

	@DeleteMapping("/catalogue/{id}")
	public ResultWrapper<Catalogue> removeCatalogue(@PathVariable("id") Long id) {
		return new ResultWrapper<Catalogue>(catalogueService.removeCatalogue(id), "Remove catalogue " + id,
				catalogueService.getAllCatalogues());
	}
}
