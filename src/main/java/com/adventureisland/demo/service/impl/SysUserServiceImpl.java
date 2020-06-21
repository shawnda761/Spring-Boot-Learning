package com.adventureisland.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adventureisland.demo.entity.SysUser;
import com.adventureisland.demo.repository.SysUserRepository;
import com.adventureisland.demo.service.SysUserService;
import com.adventureisland.demo.util.ConstantUtil;

@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	SysUserRepository userRepo;

	@Override
	public List<SysUser> getUsers() {
		return userRepo.findAll();
	}

	@Override
	public List<SysUser> getUsersByAccountId(String accountId) {
		return userRepo.findByAccountIdLike(ConstantUtil.wrapperOfLike(accountId));
	}

	@Override
	public List<SysUser> getUsersByLockFlag(Integer lockFlag) {
		return userRepo.findByLockFlag(lockFlag);
	}

	@Override
	public List<SysUser> getUsersByAvailableFlag(Integer availableFlag) {
		return userRepo.findByAvailableFlag(availableFlag);
	}

	@Override
	public List<SysUser> getUsersByName(String name) {
		return userRepo.findByNameLike(ConstantUtil.wrapperOfLike(name));
	}

	@Override
	public List<SysUser> getUsersByGender(Integer gender) {
		return userRepo.findByGender(gender);
	}

	@Override
	public List<SysUser> getUsersByEmail(String email) {
		return userRepo.findByEmailLike(ConstantUtil.wrapperOfLike(email));
	}

	@Override
	public List<SysUser> getUsersByContactNumber(String contactNumber) {
		return userRepo.findByContactNumberLike(ConstantUtil.wrapperOfLike(contactNumber));
	}

	@Override
	public boolean createUser(SysUser user) {
		userRepo.saveAndFlush(user);
		return true;
	}

	@Override
	public boolean updateUser(SysUser user) {
		userRepo.saveAndFlush(user);
		return true;
	}

	@Override
	public boolean updatePasswordByIds(List<Long> ids, String password) {
		if (ids.size() == 1) {
			userRepo.updatePasswordById(ids.get(0), password);
		} else {
			userRepo.updatePasswordByIds(ids, password);
		}
		return true;
	}

	@Override
	public boolean updateLockFlagByIds(List<Long> ids, Integer lockFlag) {
		if (ids.size() == 1) {
			userRepo.updateLockFlagById(ids.get(0), lockFlag);
		} else {
			userRepo.updateLockFlagByIds(ids, lockFlag);
		}
		return true;
	}

	@Override
	public boolean updateAvailableFlagByIds(List<Long> ids, Integer availableFlag) {
		if (ids.size() == 1) {
			userRepo.updateAvailableFlagById(ids.get(0), availableFlag);
		} else {
			userRepo.updateAvailableFlagByIds(ids, availableFlag);
		}
		return true;
	}

	@Override
	public boolean removeUser(List<Long> ids) {
		if (ids.size() == 1) {
			userRepo.deleteById(ids.get(0));
		} else {
			userRepo.deleteByIds(ids);
		}
		return true;
	}

}
