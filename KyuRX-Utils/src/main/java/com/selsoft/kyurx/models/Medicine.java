package com.selsoft.kyurx.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.json.JSONObject;

@Entity
@Table(name = "RX_MEDICINE")
public class Medicine {

	private int medicineId;
	private String name;
	private String code;
	private String barCode;
	private float rate;
	private float buyingRate;
	private float sellingRate;
	private long createdAt;
	private long updatedAt;

	public int getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public float getBuyingRate() {
		return buyingRate;
	}

	public void setBuyingRate(float buyingRate) {
		this.buyingRate = buyingRate;
	}

	public float getSellingRate() {
		return sellingRate;
	}

	public void setSellingRate(float sellingRate) {
		this.sellingRate = sellingRate;
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
		jsonObject.put("medicineId", this.medicineId);
		jsonObject.put("name", this.name);
		jsonObject.put("code", this.code);
		jsonObject.put("barCode", this.barCode);
		jsonObject.put("rate", this.rate);
		jsonObject.put("buyingRate", this.buyingRate);
		jsonObject.put("sellingRate", this.sellingRate);
		jsonObject.put("createdAt", this.createdAt);
		jsonObject.put("updatedAt", this.updatedAt);
		return jsonObject;
	}

}
