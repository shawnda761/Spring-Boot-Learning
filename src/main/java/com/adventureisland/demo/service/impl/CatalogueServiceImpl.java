package com.adventureisland.demo.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adventureisland.demo.dao.CatalogueDao;
import com.adventureisland.demo.model.Catalogue;
import com.adventureisland.demo.service.CatalogueService;

@Service
public class CatalogueServiceImpl implements CatalogueService {

	@Autowired
	CatalogueDao catalogueDao;

	@Override
	public List<Catalogue> getAllCatalogues() {
		return catalogueDao.getAllCatalogues();
	}

	@Override
	public List<Catalogue> getCatalogue(Long id) {
		Catalogue basicCatalogue = catalogueDao.getCatalogueById(id);
		if (basicCatalogue != null) {
			Long parentId = basicCatalogue.getParentId();
			while (parentId != -1) {
				Catalogue parentCatalogue = catalogueDao.getCatalogueById(parentId);
				basicCatalogue.setName(parentCatalogue.getName() + " - " + basicCatalogue.getName());
				parentId = parentCatalogue.getParentId();
			}
		}
		return Arrays.asList(basicCatalogue);
	}

	@Override
	public boolean addCatalogue(Catalogue catalogue) {
		catalogueDao.insertCatalogue(catalogue);
		return true;
	}

	@Override
	public boolean updateCatalogue(Catalogue catalogue) {
		catalogueDao.updateCatalogue(catalogue);
		return true;
	}

	@Override
	public boolean removeCatalogue(Long id) {
		catalogueDao.deleteCatalogue(id);
		return true;
	}

}
