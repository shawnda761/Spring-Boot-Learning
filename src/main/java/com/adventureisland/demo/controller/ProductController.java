package com.adventureisland.demo.controller;

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
import com.adventureisland.demo.model.QueryParameter;
import com.adventureisland.demo.service.ProductService;
import com.adventureisland.demo.util.ResultWrapper;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("/product/all")
	public ResultWrapper<Product> getAllProducts() {
		List<Product> productList = productService.getAllProducts();
		return new ResultWrapper<Product>((productList != null && productList.size() > 0), ("Get all products"),
				productList);
	}

	@GetMapping("/productInfo/all")
	public ResultWrapper<Product> getAllProductsInfo() {
		List<Product> productInfoList = productService.getAllProductsInfo();
		return new ResultWrapper<Product>((productInfoList != null && productInfoList.size() > 0), ("Get all products"),
				productInfoList);
	}

	@GetMapping("/product/{id}")
	public ResultWrapper<Product> getProductById(@PathVariable("id") Long id) {
		List<Product> singleProduct = productService.getProductById(id);
		return new ResultWrapper<Product>((singleProduct != null && singleProduct.size() > 0), ("Get product " + id),
				singleProduct);
	}

	@GetMapping("/productsInfo/{name}")
	public ResultWrapper<Product> getProductInfoByName(@PathVariable("name") String name) {
		List<Product> productInfoList = productService.getProductInfoByName(name);
		return new ResultWrapper<Product>((productInfoList != null && productInfoList.size() > 0),
				"Get product info by name", productInfoList);
	}

	@GetMapping("/productPriceTrend")
	public ResultWrapper<Product> getProductPriceTrend(@RequestBody QueryParameter queryParameter) {
		List<Product> productPriceList = productService.getProductPriceTrend(queryParameter);
		return new ResultWrapper<Product>((productPriceList != null && productPriceList.size() > 0),
				"Get product price trend", productPriceList);
	}

	@GetMapping("/productInfo/{id}")
	public ResultWrapper<Product> getProductInfoById(@PathVariable("id") Long id) {
		List<Product> singleProductInfo = productService.getProductInfoById(id);
		return new ResultWrapper<Product>((singleProductInfo != null && singleProductInfo.size() > 0),
				("Get product " + id), singleProductInfo);
	}

	@PostMapping("/product/add")
	public ResultWrapper<Product> addProduct(@RequestBody Product product) {
		return new ResultWrapper<Product>(productService.addProduct(product), "Add new product",
				productService.getAllProductsInfo());
	}

	@PostMapping("/productPrice/add")
	public ResultWrapper<Product> addProductPrice(@RequestBody Product product) {
		return new ResultWrapper<Product>(productService.addProductPrice(product), "Add new product price",
				productService.getAllProductsInfo());
	}

	@PostMapping("/productStock/add")
	public ResultWrapper<Product> addProductStock(@RequestBody Product product) {
		return new ResultWrapper<Product>(productService.addProductStock(product), "Add new product stock",
				productService.getAllProductsInfo());
	}

	@PostMapping("/productInfo/add")
	public ResultWrapper<Product> addProductInfo(@RequestBody Product product) {
		return new ResultWrapper<Product>(productService.addProductInfo(product), "Add new product info",
				productService.getAllProductsInfo());
	}

	@PutMapping("/product/update")
	public ResultWrapper<Product> updateProduct(@RequestBody Product product) {
		return new ResultWrapper<Product>(productService.updateProduct(product), ("Update product " + product.getId()),
				productService.getAllProductsInfo());
	}

	@PutMapping("/productPrice/update")
	public ResultWrapper<Product> updateProductPrice(@RequestBody Product product) {
		return new ResultWrapper<Product>(productService.updateProductPrice(product),
				("Update product " + product.getProductId() + "'s price"), productService.getAllProductsInfo());
	}

	@PutMapping("/productStock/update")
	public ResultWrapper<Product> updateProductStock(@RequestBody Product product) {
		return new ResultWrapper<Product>(productService.updateProductStock(product),
				("Update product " + product.getProductId() + "'s stock"), productService.getAllProductsInfo());
	}

	@PutMapping("/productInfo/update")
	public ResultWrapper<Product> updateProductInfo(@RequestBody Product product) {
		return new ResultWrapper<Product>(productService.updateProductInfo(product),
				("Update product " + product.getId() + "'s info"), productService.getAllProductsInfo());
	}

	@DeleteMapping("/product/{id}")
	public ResultWrapper<Product> removeProduct(@PathVariable("id") Long id) {
		return new ResultWrapper<Product>(productService.removeProduct(id), ("Update product " + id),
				productService.getAllProductsInfo());
	}

	@DeleteMapping("/productPrice/{id}")
	public ResultWrapper<Product> removeProductPrice(@PathVariable("id") Long id) {
		return new ResultWrapper<Product>(productService.removeProductPrice(id), ("Update product " + id + "'s price"),
				productService.getAllProductsInfo());
	}

	@DeleteMapping("/productStock/{id}")
	public ResultWrapper<Product> removeProductStock(@PathVariable("id") Long id) {
		return new ResultWrapper<Product>(productService.removeProductStock(id), ("Update product " + id + "'s stock"),
				productService.getAllProductsInfo());
	}

	@DeleteMapping("/productInfo/{id}")
	public ResultWrapper<Product> removeProductInfo(@PathVariable("id") Long id) {
		return new ResultWrapper<Product>(productService.removeProductInfo(id), ("Update product " + id + "'s info"),
				productService.getAllProductsInfo());
	}
}
