package com.adventureisland.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.adventureisland.demo.model.Catalogue;

@Mapper
public interface CatalogueDao {

	public List<Catalogue> getAllCatalogues();

	public Catalogue getCatalogueById(Long id);

	public void insertCatalogue(Catalogue catalogue);

	public void updateCatalogue(Catalogue catalogue);

	public void deleteCatalogue(Long id);
}
