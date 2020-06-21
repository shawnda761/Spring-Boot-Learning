package com.adventureisland.demo.service;

import java.util.List;

import com.adventureisland.demo.entity.SysOrganisation;

public interface SysOrganisationService {

	public List<SysOrganisation> getOrganisations();

	public List<SysOrganisation> getOrganisationsByCode(String code);

	public List<SysOrganisation> getOrganisationsByName(String name);

	public boolean createOrganisation(SysOrganisation organisation);

	public boolean updateOrganisation(SysOrganisation organisation);

	public boolean removeOrganisation(List<Long> ids);

}
