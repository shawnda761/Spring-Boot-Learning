package com.adventureisland.demo.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SYS_OPERATION", schema = "secondaryDB")
public class SysOperation implements Serializable {

	private static final long serialVersionUID = 15L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long uid;

	@Column(name = "OPERATION_CODE", nullable = false, length = 100)
	private String operationCode;

	@Column(name = "OPERATION_NAME", nullable = false, length = 100)
	private String operationName;

	@Column(name = "COMMENT", nullable = true, length = 512)
	private String comment;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "RESOURCE_ID")
	private SysResource resource;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "ROLE_ID")
	private SysRole role;

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public String getOperationCode() {
		return operationCode;
	}

	public void setOperationCode(String operationCode) {
		this.operationCode = operationCode;
	}

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public SysResource getResource() {
		return resource;
	}

	public void setResource(SysResource resource) {
		this.resource = resource;
	}

	public SysRole getRole() {
		return role;
	}

	public void setRole(SysRole role) {
		this.role = role;
	}

}
