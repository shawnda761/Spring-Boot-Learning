package com.adventureisland.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adventureisland.demo.service.PurchaseService;

@RestController
public class PurchaseController {

	@Autowired
	PurchaseService purchaseService;

	@PostMapping("/purchase/{userId}/{productId}/{amount}")
	public Result purchase(@PathVariable("userId") Long userId, @PathVariable("productId") Long productId,
			@PathVariable("amount") Integer amount) {
		boolean success = purchaseService.purchase(userId, productId, amount);
		String message = success ? "purchase success" : "purchase failure";
		Result result = new Result(success, message);
		return result;
	}

	class Result {
		private boolean success = false;
		private String message = null;

		public Result() {

		}

		public Result(boolean success, String message) {
			this.success = success;
			this.message = message;
		}

		public boolean isSuccess() {
			return success;
		}

		public void setSuccess(boolean success) {
			this.success = success;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

	}
}
