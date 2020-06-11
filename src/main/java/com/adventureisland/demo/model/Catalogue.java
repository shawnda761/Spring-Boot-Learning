package com.adventureisland.demo.model;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

@Alias("catalogue")
public class Catalogue implements Serializable {

	public static final long serialVersionUID = 0L;

	private Long id;

	private Long parentId;

	private String name;

	private Timestamp updateTime;

	private int version;

	private String comment;
	
	public Catalogue() {

	}

	public Catalogue(Long id, Long parentId, String name, Timestamp updateTime, int version, String comment) {
		this.id = id;
		this.parentId = parentId;
		this.name = name;
		this.updateTime = updateTime;
		this.version = version;
		this.comment = comment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
