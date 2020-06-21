package com.adventureisland.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adventureisland.demo.entity.SysResource;
import com.adventureisland.demo.repository.SysResourceRepository;
import com.adventureisland.demo.service.SysResourceService;
import com.adventureisland.demo.util.ConstantUtil;

@Service
public class SysResourceServiceImpl implements SysResourceService {

	@Autowired
	SysResourceRepository resourceRepo;

	@Override
	public List<SysResource> getResources() {
		return resourceRepo.findAll();
	}

	@Override
	public List<SysResource> getResourcesByCode(String code) {
		return resourceRepo.findByResourceCodeLike(ConstantUtil.wrapperOfLike(code));
	}

	@Override
	public List<SysResource> getResourcesByName(String name) {
		return resourceRepo.findByResourceNameLike(ConstantUtil.wrapperOfLike(name));
	}

	@Override
	public List<SysResource> getResourcesByType(String type) {
		return resourceRepo.findByResourceTypeLike(ConstantUtil.wrapperOfLike(type));
	}

	@Override
	public List<SysResource> getResourcesByUri(String uri) {
		return resourceRepo.findByResourceUriLike(ConstantUtil.wrapperOfLike(uri));
	}

	@Override
	public boolean createResource(SysResource resource) {
		resourceRepo.saveAndFlush(resource);
		return true;
	}

	@Override
	public boolean updateResource(SysResource resource) {
		resourceRepo.saveAndFlush(resource);
		return true;
	}

	@Override
	public boolean removeResource(List<Long> ids) {
		if (ids.size() == 1) {
			resourceRepo.deleteById(ids.get(0));
		} else {
			resourceRepo.deleteByIds(ids);
		}
		return true;
	}

}
