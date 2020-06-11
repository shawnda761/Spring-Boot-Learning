package com.adventureisland.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

@Alias("product")
public class Product implements Serializable {

	public static final long serialVersionUID = 1L;

	private Long id;

	private Long catalogueId;

	private String catalogueName;
	
	private Long productId;

	private String name;

	// double and float are not so precise to represent price so use the
	// java.math.BigDecimal type
	private BigDecimal price;

	private int stockAmount;

	private Timestamp updateTime;

	private int version;

	private String comment;

	public Product() {

	}

	public Product(Long id, Long productId, BigDecimal price, Timestamp updateTime, int version, String comment) {
		this.id = id;
		this.productId = productId;
		this.price = price;
		this.updateTime = updateTime;
		this.version = version;
		this.comment = comment;
	}

	public Product(Long id, Long productId, int stockAmount, Timestamp updateTime, int version, String comment) {
		this.id = id;
		this.productId = productId;
		this.stockAmount = stockAmount;
		this.updateTime = updateTime;
		this.version = version;
		this.comment = comment;
	}

	public Product(Long id, String name, BigDecimal price, int stockAmount, int version, String comment) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.stockAmount = stockAmount;
		this.version = version;
		this.comment = comment;
	}

	public Product(Long id, Long catalogueId, String name, Timestamp updateTime, int version, String comment) {
		this.id = id;
		this.catalogueId = catalogueId;
		this.name = name;
		this.updateTime = updateTime;
		this.version = version;
		this.comment = comment;
	}

	public Product(Long id, Long catalogueId, String catalogueName, Long productId, String name, BigDecimal price, int stockAmount,
			Timestamp updateTime, int version, String comment) {
		this.id = id;
		this.catalogueId = catalogueId;
		this.catalogueName = catalogueName;
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.stockAmount = stockAmount;
		this.updateTime = updateTime;
		this.version = version;
		this.comment = comment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCatalogueId() {
		return catalogueId;
	}

	public void setCatalogueId(Long catalogueId) {
		this.catalogueId = catalogueId;
	}

	public String getCatalogueName() {
		return catalogueName;
	}

	public void setCatalogueName(String catalogueName) {
		this.catalogueName = catalogueName;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
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

	public int getStockAmount() {
		return stockAmount;
	}

	public void setStockAmount(int stockAmount) {
		this.stockAmount = stockAmount;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
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
