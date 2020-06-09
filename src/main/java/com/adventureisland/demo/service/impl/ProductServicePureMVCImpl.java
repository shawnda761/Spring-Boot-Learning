package com.adventureisland.demo.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.adventureisland.demo.model.Product;
import com.adventureisland.demo.service.ProductService;

@Service
public class ProductServicePureMVCImpl implements ProductService {

	private Product productForError = new Product(-1L, "", new BigDecimal(-9999.99), 0, 0, "");

	private List<Product> productSamples = new ArrayList<Product>();
	
	public ProductServicePureMVCImpl() {
		productSamples.add(new Product(1L, "product1", new BigDecimal(9.99), 10, 1, ""));
		productSamples.add(new Product(2L, "product2", new BigDecimal(19.99), 20, 1, ""));
		productSamples.add(new Product(3L, "product3", new BigDecimal(29.99), 30, 1, ""));
	}

	@Override
	public List<Product> getAllProducts() {
		return productSamples;
	}

	@Override
	public Product getProductById(Long id) {
		List<Product> product = productSamples.stream().filter(x -> x.getId() == id).collect(Collectors.toList());
		return (product.size() == 0) ? productForError : product.get(0);
	}

	@Override
	public boolean addProduct(Product product) {
		productSamples.add(product);
		return true;
	}

	@Override
	public boolean updateProduct(Product product) {
		List<Product> newProductSamples = new ArrayList<Product>(); 
		for (Product currProduct : productSamples) {
			if (currProduct.getId() == product.getId()) {
				newProductSamples.add(product);
			}
			else {
				newProductSamples.add(currProduct);
			}
		}
		productSamples = newProductSamples;
		return true;
	}

	@Override
	public boolean removeProduct(Long id) {
		productSamples = productSamples.stream().filter(x -> x.getId() != id).collect(Collectors.toList());
		return true;
	}

}
