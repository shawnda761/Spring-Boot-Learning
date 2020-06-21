package com.adventureisland.demo.service;

import java.util.List;

import com.adventureisland.demo.entity.SysResource;

public interface SysResourceService {

	public List<SysResource> getResources();

	public List<SysResource> getResourcesByCode(String code);

	public List<SysResource> getResourcesByName(String name);

	public List<SysResource> getResourcesByType(String type);

	public List<SysResource> getResourcesByUri(String uri);

	public boolean createResource(SysResource resource);

	public boolean updateResource(SysResource resource);

	public boolean removeResource(List<Long> ids);

}
