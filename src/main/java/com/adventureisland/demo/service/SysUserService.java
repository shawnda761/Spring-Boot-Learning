package com.adventureisland.demo.service;

import java.util.List;

import com.adventureisland.demo.entity.SysUser;

public interface SysUserService {

	public List<SysUser> getUsers();

	public List<SysUser> getUsersByAccountId(String accountId);

	public List<SysUser> getUsersByLockFlag(Integer lockFlag);

	public List<SysUser> getUsersByAvailableFlag(Integer availableFlag);

	public List<SysUser> getUsersByName(String name);

	public List<SysUser> getUsersByGender(Integer gender);

	public List<SysUser> getUsersByEmail(String email);

	public List<SysUser> getUsersByContactNumber(String contactNumber);

	public boolean createUser(SysUser user);

	public boolean updateUser(SysUser user);

	public boolean updatePasswordByIds(List<Long> ids, String password);

	public boolean updateLockFlagByIds(List<Long> ids, Integer lockFlag);

	public boolean updateAvailableFlagByIds(List<Long> ids, Integer availableFlag);

	public boolean removeUser(List<Long> ids);

}
