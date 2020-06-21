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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SYS_ORGANISATION", schema = "secondaryDB")
public class SysOrganisation implements Serializable {

	private static final long serialVersionUID = 14L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long uid;

	@Column(name = "ORGANISATION_CODE", unique = true, nullable = false, length = 100)
	private String organisationCode;

	@Column(name = "ORGANISATION_NAME", nullable = false, length = 100)
	private String organisationName;

	@Column(name = "COMMENT", nullable = true, length = 512)
	private String comment;

	@ManyToOne
	@JoinColumn(name = "PARENT_ID")
	private SysOrganisation parentOrganisation;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_ID")
	private Set<SysOrganisation> children = new HashSet<SysOrganisation>();

	@OneToMany(mappedBy = "organisation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<SysUser> users = new HashSet<SysUser>();

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public String getOrganisationCode() {
		return organisationCode;
	}

	public void setOrganisationCode(String organisationCode) {
		this.organisationCode = organisationCode;
	}

	public String getOrganisationName() {
		return organisationName;
	}

	public void setOrganisationName(String organisationName) {
		this.organisationName = organisationName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public SysOrganisation getParentOrganisation() {
		return parentOrganisation;
	}

	public void setParentOrganisation(SysOrganisation parentOrganisation) {
		this.parentOrganisation = parentOrganisation;
	}

	public Set<SysOrganisation> getChildren() {
		return children;
	}

	public void setChildren(Set<SysOrganisation> children) {
		this.children = children;
	}

	public Set<SysUser> getUsers() {
		return users;
	}

	public void setUsers(Set<SysUser> users) {
		this.users = users;
	}

}
