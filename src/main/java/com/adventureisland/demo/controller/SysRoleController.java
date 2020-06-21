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

import com.adventureisland.demo.entity.SysRole;
import com.adventureisland.demo.service.SysRoleService;

@RestController
@RequestMapping("/manage/role")
public class SysRoleController {

	@Autowired
	SysRoleService roleService;

	@GetMapping("/get/{method}")
	public List<SysRole> getAllRoles(@PathVariable("method") String method,
			@RequestBody(required = false) Object parameter) {
		if (method.equals("all")) {
			return roleService.getRoles();
		} else if (method.equals("code")) {
			return roleService.getRolesByCode(parameter.toString());
		} else if (method.equals("name")) {
			return roleService.getRolesByName(parameter.toString());
		}
		return null;
	}

	@PostMapping("/add")
	public void addRole(@RequestBody SysRole role) {
		roleService.createRole(role);
	}

	@PutMapping("/update")
	public void updateRole(@RequestBody SysRole role) {
		roleService.updateRole(role);
	}

	@DeleteMapping("/delete")
	public void deleteRole(@RequestBody List<Long> ids) {
		roleService.removeRole(ids);
	}

}
