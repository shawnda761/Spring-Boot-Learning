package com.adventureisland.demo.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adventureisland.demo.dao.PurchaseDao;
import com.adventureisland.demo.model.Product;
import com.adventureisland.demo.model.Purchase;
import com.adventureisland.demo.service.ProductService;
import com.adventureisland.demo.service.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	private ProductService productService;

	@Autowired
	private PurchaseDao purchaseDao;

	@Override
	@Transactional
	public boolean purchase(Long userId, Long productId, int amount) {
		Product product = productService.getProductById(productId).get(0);
		if (product.getStockAmount() < amount) {
			return false;
		}
		product.setStockAmount(product.getStockAmount() - amount);
		purchaseDao.insertPurchaseRecord(initPurchase(userId, product, amount));
		return true;
	}

	private Purchase initPurchase(Long userId, Product product, int amount) {
		Purchase purchaseRecord = new Purchase();
		purchaseRecord.setUserId(userId);
		purchaseRecord.setProductId(product.getId());
		purchaseRecord.setPrice(product.getPrice());
		purchaseRecord.setAmount(amount);
		purchaseRecord.setSummary(new BigDecimal(product.getPrice().doubleValue() * amount));
		purchaseRecord.setComment("purchase record log, time: " + System.currentTimeMillis());
		return purchaseRecord;
	}

}
