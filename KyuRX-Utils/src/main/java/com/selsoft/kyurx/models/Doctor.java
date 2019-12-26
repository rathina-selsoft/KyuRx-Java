package com.selsoft.kyurx.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.json.JSONObject;

@Entity
@Table(name = "RX_DOCTOR")
public class Doctor {

	private int doctorId;
	private int roleId;
	private UserRole userRole;
	private String firstName;
	private String lastName;
	private String imageUrl;
	private String specialist;
	private String qualification;
	private String gender;
	private String emailId;
	private String phoneNumber;
	private double lat;
	private double lon;
	private String hospitalId;
	private String availability;
	private long createdAt;
	private long updatedAt;

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getSpecialist() {
		return specialist;
	}

	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
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
		jsonObject.put("doctorId", this.doctorId);
		jsonObject.put("roleId", this.roleId);
		jsonObject.put("userRole", this.userRole);
		jsonObject.put("firstName", this.firstName);
		jsonObject.put("lastName", this.lastName);
		jsonObject.put("imageUrl", this.imageUrl);
		jsonObject.put("specialist", this.specialist);
		jsonObject.put("qualification", this.qualification);
		jsonObject.put("gender", this.gender);
		jsonObject.put("emailId", this.emailId);
		jsonObject.put("phoneNumber", this.phoneNumber);
		jsonObject.put("lat", this.lat);
		jsonObject.put("lon", this.lon);
		jsonObject.put("hospitalId", this.hospitalId);
		jsonObject.put("availability", this.availability);
		jsonObject.put("createdAt", this.createdAt);
		jsonObject.put("updatedAt", this.updatedAt);
		return jsonObject;
	}

}
