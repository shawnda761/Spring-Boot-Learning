package com.adventureisland.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adventureisland.demo.service.PurchaseService;
import com.adventureisland.demo.util.ResultWrapper;

@RestController
public class PurchaseController {

	@Autowired
	PurchaseService purchaseService;

	@PostMapping("/purchase/{userId}/{productId}/{amount}")
	public ResultWrapper<?> purchase(@PathVariable("userId") Long userId, @PathVariable("productId") Long productId,
			@PathVariable("amount") Integer amount) {
		return new ResultWrapper<Object>(purchaseService.purchase(userId, productId, amount), "purchase");
	}

}
