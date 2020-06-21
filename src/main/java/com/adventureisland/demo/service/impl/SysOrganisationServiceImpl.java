package com.adventureisland.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adventureisland.demo.entity.SysOrganisation;
import com.adventureisland.demo.repository.SysOrganisationRepository;
import com.adventureisland.demo.service.SysOrganisationService;
import com.adventureisland.demo.util.ConstantUtil;

@Service
public class SysOrganisationServiceImpl implements SysOrganisationService {

	@Autowired
	SysOrganisationRepository organisationRepo;

	@Override
	public List<SysOrganisation> getOrganisations() {
		return organisationRepo.findAll();
	}

	@Override
	public List<SysOrganisation> getOrganisationsByCode(String code) {
		return organisationRepo.findByOrganisationCodeLike(ConstantUtil.wrapperOfLike(code));
	}

	@Override
	public List<SysOrganisation> getOrganisationsByName(String name) {
		return organisationRepo.findByOrganisationNameLike(ConstantUtil.wrapperOfLike(name));
	}

	@Override
	public boolean createOrganisation(SysOrganisation organisation) {
		organisationRepo.saveAndFlush(organisation);
		return true;
	}

	@Override
	public boolean updateOrganisation(SysOrganisation organisation) {
		organisationRepo.saveAndFlush(organisation);
		return true;
	}

	@Override
	public boolean removeOrganisation(List<Long> ids) {
		if (ids.size() == 1) {
			organisationRepo.deleteById(ids.get(0));
		} else {
			organisationRepo.deleteByIds(ids);
		}
		return true;
	}

}
