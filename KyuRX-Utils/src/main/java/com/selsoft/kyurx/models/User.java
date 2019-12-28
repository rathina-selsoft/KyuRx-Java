package com.selsoft.kyurx.models;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.json.JSONObject;

@Entity
@Table(name = "RX_USER")
public class User {

	private int userId;
	private String userRole;
	private String firstName;
	private String lastName;
	private String emailId;
	private String userName;
	private String phoneNumber;
	private String imageUrl;
	private String password;
	private String salt;
	private String fcmToken;
	private Timestamp createdAt;
	private Timestamp updatedAt;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getFcmToken() {
		return fcmToken;
	}

	public void setFcmToken(String fcmToken) {
		this.fcmToken = fcmToken;
	}
	
	public JSONObject toJSON() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("userId", this.userId);
		jsonObject.put("userRole", this.userRole);
		jsonObject.put("firstName", this.firstName);
		jsonObject.put("lastName", this.lastName);
		jsonObject.put("emailId", this.emailId);
		jsonObject.put("userName", this.userName);
		jsonObject.put("phoneNumber", this.phoneNumber);
		jsonObject.put("imageUrl", this.imageUrl);
		jsonObject.put("createdAt", this.createdAt);
		jsonObject.put("updatedAt", this.updatedAt);
		return jsonObject;
	}

}
