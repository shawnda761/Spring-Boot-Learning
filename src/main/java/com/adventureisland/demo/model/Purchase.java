package com.adventureisland.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

@Alias("purchase")
public class Purchase implements Serializable {

	private static final long serialVersionUID = 2L;

	private Long id;

	private Long userId;

	private Long productId;

	private BigDecimal price;

	private int amount;

	private BigDecimal summary;

	private Timestamp purchaseTime;

	private String comment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public BigDecimal getSummary() {
		return summary;
	}

	public void setSummary(BigDecimal summary) {
		this.summary = summary;
	}

	public Timestamp getPurchaseTime() {
		return purchaseTime;
	}

	public void setPurchaseTime(Timestamp purchaseTime) {
		this.purchaseTime = purchaseTime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
