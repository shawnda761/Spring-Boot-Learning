package com.adventureisland.demo.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adventureisland.demo.model.Product;
import com.adventureisland.demo.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("/product/all")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/product/{id}")
	public Product getProductById(@PathVariable("id") Long id) {
		return productService.getProductById(id);
	}

	@PostMapping("/product/{productInfo}")
	public List<Product> addProductByPathVariable(@PathVariable("productInfo") String productInfo) {
		Product newProduct = new Product();
		newProduct.setId(Long.valueOf(productInfo.split("_")[0]));
		newProduct.setName(productInfo.split("_")[1]);
		newProduct.setPrice(new BigDecimal(productInfo.split("_")[2]));
		newProduct.setStock(Integer.valueOf(productInfo.split("_")[3]));
		newProduct.setVersion(Integer.valueOf(productInfo.split("_")[4]));
		newProduct.setComment(productInfo.split("_")[5]);
		if (productService.addProduct(newProduct)) {
			return productService.getAllProducts();
		}
		return null;
	}

	@PostMapping("/product/add")
	public List<Product> addProductByRequestBody(@RequestBody Product product) {
		if (productService.addProduct(product)) {
			return productService.getAllProducts();
		}
		return null;
	}

	@PutMapping("/product/{productInfo}")
	public List<Product> updateProductByPathVariable(@PathVariable("productInfo") String productInfo) {
		Product newProduct = new Product();
		newProduct.setId(Long.valueOf(productInfo.split("_")[0]));
		newProduct.setName(productInfo.split("_")[1]);
		newProduct.setPrice(new BigDecimal(productInfo.split("_")[2]));
		newProduct.setStock(Integer.valueOf(productInfo.split("_")[3]));
		newProduct.setVersion(Integer.valueOf(productInfo.split("_")[4]));
		newProduct.setComment(productInfo.split("_")[5]);
		if (productService.updateProduct(newProduct)) {
			return productService.getAllProducts();
		}
		return null;
	}

	@PutMapping("/product/update")
	public List<Product> updateProductByRequestBody(@RequestBody Product product) {
		if (productService.updateProduct(product)) {
			return productService.getAllProducts();
		}
		return null;
	}

	@DeleteMapping("/product/{id}")
	public List<Product> addProduct(@PathVariable("id") Long id) {
		if (productService.removeProduct(id)) {
			return productService.getAllProducts();
		}
		return null;
	}
}
