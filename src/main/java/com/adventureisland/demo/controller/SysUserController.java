package com.adventureisland.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adventureisland.demo.entity.SysUser;
import com.adventureisland.demo.service.SysUserService;
import com.adventureisland.demo.util.ConstantUtil;

@RestController
@RequestMapping("/manage/user")
public class SysUserController {

	@Autowired
	SysUserService userService;

	@GetMapping("/get/{method}")
	public List<SysUser> getAllUsers(@PathVariable("method") String method,
			@RequestBody(required = false) Object parameter) {
		if (method.equals("all")) {
			return userService.getUsers();
		} else if (method.equals("accountId")) {
			return userService.getUsersByAccountId(parameter.toString());
		} else if (method.equals("lockFlag")) {
			return userService.getUsersByLockFlag(Integer.valueOf(parameter.toString()));
		} else if (method.equals("availableFlag")) {
			return userService.getUsersByAvailableFlag(Integer.valueOf(parameter.toString()));
		} else if (method.equals("name")) {
			return userService.getUsersByName(parameter.toString());
		} else if (method.equals("gender")) {
			return userService.getUsersByGender(Integer.valueOf(parameter.toString()));
		} else if (method.equals("email")) {
			return userService.getUsersByEmail(parameter.toString());
		} else if (method.equals("contactNumber")) {
			return userService.getUsersByContactNumber(parameter.toString());
		}
		return null;
	}

	@PostMapping("/add")
	public void addUser(@RequestBody SysUser user) {
		if (user.getPassword() == null) {
			user.setPassword(ConstantUtil.SYS_DEFAULT_PASSWORD);
		}
		userService.createUser(user);
	}

	@PutMapping("/update")
	public void updateUser(@RequestBody SysUser user) {
		userService.updateUser(user);
	}

	@PutMapping("/{method}")
	public void updateFeature(@PathVariable("method") String method, @RequestBody List<Long> ids) {
		if (method.equals("resetPassword")) {
			userService.updatePasswordByIds(ids, ConstantUtil.SYS_DEFAULT_PASSWORD);
		} else if (method.equals("lock")) {
			userService.updateLockFlagByIds(ids, 1);
		} else if (method.equals("unlock")) {
			userService.updateLockFlagByIds(ids, 0);
		} else if (method.equals("activate")) {
			userService.updateAvailableFlagByIds(ids, 1);
		} else if (method.equals("hibernate")) {
			userService.updateAvailableFlagByIds(ids, 0);
		}
	}

	@DeleteMapping("/delete")
	public void deleteUser(@RequestBody List<Long> ids) {
		userService.removeUser(ids);
	}

}
