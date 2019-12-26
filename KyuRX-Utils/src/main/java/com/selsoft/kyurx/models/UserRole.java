package com.selsoft.kyurx.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.json.JSONObject;

@Entity
@Table(name = "RX_USER_ROLE")
public class UserRole {

	private int userRoleId;
	private String emailId;
	private String userName;
	private String role;
	private long createdAt;
	private long updatedAt;

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
	}

	public long getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(long updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public JSONObject toJSON() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("userRoleId", this.userRoleId);
		jsonObject.put("emailId", this.emailId);
		jsonObject.put("userName", this.userName);
		jsonObject.put("role", this.role);
		jsonObject.put("createdAt", this.createdAt);
		jsonObject.put("updatedAt", this.updatedAt);
		return jsonObject;
	}

}
