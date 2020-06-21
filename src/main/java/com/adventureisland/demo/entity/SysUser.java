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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SYS_USER", schema = "secondaryDB")
public class SysUser implements Serializable {

	private static final long serialVersionUID = 11L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long uid;

	@Column(name = "ACCOUNT_ID", unique = true, nullable = false, length = 100)
	private String accountId;

	@Column(name = "PASSWORD", nullable = false, length = 100)
	private String password;

	@Column(name = "LOCK_FLAG", nullable = false, columnDefinition = "int default 0")
	private Integer lockFlag = 0;

	@Column(name = "AVAILABLE_FLAG", nullable = false, columnDefinition = "int default 1")
	private Integer availableFlag = 1;

	@Column(name = "NAME", length = 100)
	private String name;

	@Column(name = "GENDER")
	private Integer gender;

	@Column(name = "EMAIL", length = 100)
	private String email;

	@Column(name = "CONTACT_NUMBER", length = 20)
	private String contactNumber;

	@Column(name = "COMMENT", length = 512)
	private String comment;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "ORGANISATION_ID")
	private SysOrganisation organisation;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "SYS_USER_ROLE", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "ROLE_ID") })
	private Set<SysRole> roles = new HashSet<SysRole>();

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getLockFlag() {
		return lockFlag;
	}

	public void setLockFlag(Integer lockFlag) {
		this.lockFlag = lockFlag;
	}

	public Integer getAvailableFlag() {
		return availableFlag;
	}

	public void setAvailableFlag(Integer availableFlag) {
		this.availableFlag = availableFlag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public SysOrganisation getOrganisation() {
		return organisation;
	}

	public void setOrganisation(SysOrganisation organisation) {
		this.organisation = organisation;
	}

	public Set<SysRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<SysRole> roles) {
		this.roles = roles;
	}

}
