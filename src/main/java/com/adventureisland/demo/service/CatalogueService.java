package com.adventureisland.demo.service;

import java.util.List;

import com.adventureisland.demo.model.Catalogue;

public interface CatalogueService {

	public List<Catalogue> getAllCatalogues();

	public List<Catalogue> getCatalogue(Long id);

	public boolean addCatalogue(Catalogue catalogue);

	public boolean updateCatalogue(Catalogue catalogue);

	public boolean removeCatalogue(Long id);
}
