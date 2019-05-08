package com.restclient.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Transaction {

	@JsonProperty("user-id")
	private long userId;
	private String merchant;
	private double price;
	@JsonProperty("purchase-date")
	private Date purchaseDate;
	@JsonProperty("tx-id")
	private long tranId;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getMerchant() {
		return merchant;
	}

	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public long getTranId() {
		return tranId;
	}

	public void setTranId(long tranId) {
		this.tranId = tranId;
	}

	@Override
	public String toString() {
		return "txn-id: '" + this.tranId + "', userId: '" + this.userId + "', merchant: '" + this.merchant
				+ "', price: '" + this.price + "', purchased date: '" + this.purchaseDate + "'";
	}
}
