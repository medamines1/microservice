package com.proxym.bo.model;

import java.util.Date;

import com.proxym.bo.enumerations.FeaturesEnum;


public class UserActionModel {
	private long id;
	private String username;
	private Boolean isSuccess;
	private Date actionDate;
	private FeaturesEnum action; 
	private String actionData;
	private String exceptionData;

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Boolean getIsSuccess() {
		return isSuccess;
	}
	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public Date getActionDate() {
		return actionDate;
	}
	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}
	public FeaturesEnum getAction() {
		return action;
	}
	public void setAction(FeaturesEnum action) {
		this.action = action;
	}
	public String getActionData() {
		return actionData;
	}
	public void setActionData(String actionData) {
		this.actionData = actionData;
	}
	public String getExceptionData() {
		return exceptionData;
	}
	public void setExceptionData(String exceptionData) {
		this.exceptionData = exceptionData;
	}
	public UserActionModel() {
	}
	public static Builder newBuilder() {
		return new Builder();
	}

	public UserActionModel(Builder builder) {
		if(builder.id != null)
			this.id = builder.id;
		this.username = builder.username;
		this.isSuccess = builder.isSuccess;
		this.actionDate = builder.actionDate;
		this.actionData = builder.actionData;
		this.action = builder.action;
		this.exceptionData = builder.exceptionData;
	}

	public static class Builder {
		private Long id;
		private String username;
		private Boolean isSuccess;
		private FeaturesEnum action; 
		private String actionData;
		private Date actionDate;
		private String exceptionData;
		public Builder id(Long id) {
			this.id = id;
			return this;
		}
		
		public Builder id(long id) {
			this.id = id;
			return this;
		}

		public Builder username(String username) {
			this.username = username;
			return this;
		}
		public Builder actionData(String actionData) {
			this.actionData = actionData;
			return this;
		}
		
		public Builder exceptionData(String exceptionData) {
			this.exceptionData = exceptionData;
			return this;
		}

		public Builder isSuccess(Boolean isSuccess) {
			this.isSuccess = isSuccess;
			return this;
		}

		public Builder action(FeaturesEnum action) {
			this.action = action;
			return this;
		}

		public Builder actionDate(Date actionDate) {
			this.actionDate = actionDate;
			return this;
		}

		public UserActionModel build() {
			return new UserActionModel(this);
		}

	}

}
