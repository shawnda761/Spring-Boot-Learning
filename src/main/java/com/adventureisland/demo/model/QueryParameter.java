package com.adventureisland.demo.model;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

@Alias("queryParameter")
public class QueryParameter {
	
	private Long id;
	
	private Timestamp startTime = null;
	
	private Timestamp endTime = null;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

}
