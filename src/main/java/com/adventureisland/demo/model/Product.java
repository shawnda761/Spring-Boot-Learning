package com.adventureisland.demo.model;

import java.math.BigDecimal;

public class Product {

	private Long id;

	private String name;

	// double and float are not so precise to represent price so use the
	// java.math.BigDecimal type
	private BigDecimal price;

	private int stock;

	private int version;

	private String comment;

	public Product() {

	}

	public Product(Long id, String name, BigDecimal price, int stock, int version, String comment) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.version = version;
		this.comment = comment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
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
