package com.adventureisland.demo.service;

public interface PurchaseService {

	public boolean purchase(Long userId, Long productId, int amount);

}
