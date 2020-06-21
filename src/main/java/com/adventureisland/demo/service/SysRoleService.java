package com.adventureisland.demo.service;

import java.util.List;

import com.adventureisland.demo.entity.SysRole;

public interface SysRoleService {

	public List<SysRole> getRoles();
	
	public List<SysRole> getRolesByCode(String code);

	public List<SysRole> getRolesByName(String name);

	public boolean createRole(SysRole role);
	
	public boolean updateRole(SysRole role);
	
	public boolean removeRole(List<Long> ids);

}
