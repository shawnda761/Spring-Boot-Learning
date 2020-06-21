package com.adventureisland.demo.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SYS_ROLE", schema = "secondaryDB")
public class SysRole implements Serializable {

	private static final long serialVersionUID = 12L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long uid;

	@Column(name = "ROLE_CODE", unique = true, nullable = false, length = 100)
	private String roleCode;

	@Column(name = "ROLE_NAME", nullable = false, length = 100)
	private String roleName;

	@Column(name = "COMMENT", nullable = true, length = 512)
	private String comment;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "SYS_USER_ROLE", joinColumns = { @JoinColumn(name = "ROLE_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "USER_ID") })
	private Set<SysUser> users = new HashSet<SysUser>();

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "SYS_ROLE_RESOURCE", joinColumns = { @JoinColumn(name = "ROLE_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "RESOURCE_ID") })
	private Set<SysResource> resources = new HashSet<SysResource>();

	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<SysOperation> operations = new HashSet<SysOperation>();

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Set<SysUser> getUsers() {
		return users;
	}

	public void setUsers(Set<SysUser> users) {
		this.users = users;
	}

	public Set<SysResource> getResources() {
		return resources;
	}

	public void setResources(Set<SysResource> resources) {
		this.resources = resources;
	}

	public Set<SysOperation> getOperations() {
		return operations;
	}

	public void setOperations(Set<SysOperation> operations) {
		this.operations = operations;
	}

}
