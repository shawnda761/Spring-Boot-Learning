package com.adventureisland.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adventureisland.demo.entity.SysRole;
import com.adventureisland.demo.repository.SysRoleRepository;
import com.adventureisland.demo.service.SysRoleService;
import com.adventureisland.demo.util.ConstantUtil;

@Service
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	SysRoleRepository roleRepo;

	@Override
	public List<SysRole> getRoles() {
		return roleRepo.findAll();
	}

	@Override
	public List<SysRole> getRolesByCode(String code) {
		return roleRepo.findByRoleCodeLike(ConstantUtil.wrapperOfLike(code));
	}

	@Override
	public List<SysRole> getRolesByName(String name) {
		return roleRepo.findByRoleNameLike(ConstantUtil.wrapperOfLike(name));
	}

	@Override
	public boolean createRole(SysRole role) {
		roleRepo.saveAndFlush(role);
		return true;
	}

	@Override
	public boolean updateRole(SysRole role) {
		roleRepo.saveAndFlush(role);
		return true;
	}

	@Override
	public boolean removeRole(List<Long> ids) {
		if (ids.size() == 1) {
			roleRepo.deleteById(ids.get(0));
		} else {
			roleRepo.deleteByIds(ids);
		}
		return true;
	}

}
