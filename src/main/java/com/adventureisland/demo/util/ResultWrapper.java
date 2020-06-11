package com.adventureisland.demo.util;

import java.util.ArrayList;
import java.util.List;

public class ResultWrapper<T> {

	private boolean success = false;
	private String message = null;
	private List<T> content = null;

	public ResultWrapper() {

	}

	public ResultWrapper(boolean success, String message) {
		this.success = success;
		this.message = message;
		this.content = null;
	}

	public ResultWrapper(boolean success, String message, List<T> content) {
		this.success = success;
		this.message = message;
		this.content = content;
	}

	public boolean isSuccess() {
		return this.success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return this.message + " " + ConstantUtil.Result.getResult(this.success).getValue();
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<T> getContent() {
		if ((!this.success) || (this.content == null)) {
			return new ArrayList<T>();
		} else {
			return this.content;
		}
	}

	public void setContent(List<T> content) {
		this.content = content;
	}

}
