package com.adventureisland.demo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.adventureisland.demo.model.Purchase;

@Mapper
public interface PurchaseDao {

	public int insertPurchaseRecord(Purchase purchaseRecord);

}
