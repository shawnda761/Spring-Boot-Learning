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
@Table(name = "SYS_RESOURCE", schema = "secondayDB")
public class SysResource implements Serializable {

	private static final long serialVersionUID = 13L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long uid;

	@Column(name = "RESOURCE_CODE", unique = true, nullable = false, length = 32)
	private String resourceCode;

	@Column(name = "RESOURCE_NAME", nullable = false, length = 64)
	private String resourceName;

	@Column(name = "RESOURCE_TYPE", nullable = false, length = 10, columnDefinition = "enum('menu', 'button')")
	private String resourceType;

	@Column(name = "RESOURCE_URI", nullable = true, length = 256)
	private String resourceUri;

	@Column(name = "COMMENT", nullable = true, length = 128)
	private String comment;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "SYS_ROLE_RESOURCE", joinColumns = { @JoinColumn(name = "RESOURCE_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "ROLE_ID") })
	private Set<SysRole> roles = new HashSet<SysRole>();

	@OneToMany(mappedBy = "resource", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<SysOperation> operations = new HashSet<SysOperation>();

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public String getResourceCode() {
		return resourceCode;
	}

	public void setResourceCode(String resourceCode) {
		this.resourceCode = resourceCode;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getResourceUri() {
		return resourceUri;
	}

	public void setResourceUri(String resourceUri) {
		this.resourceUri = resourceUri;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Set<SysRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<SysRole> roles) {
		this.roles = roles;
	}

	public Set<SysOperation> getOperations() {
		return operations;
	}

	public void setOperations(Set<SysOperation> operations) {
		this.operations = operations;
	}

}
