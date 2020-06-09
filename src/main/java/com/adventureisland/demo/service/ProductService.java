package com.adventureisland.demo.service;

import java.util.List;

import com.adventureisland.demo.model.Product;

public interface ProductService {

	public List<Product> getAllProducts();

	public Product getProductById(Long id);

	public boolean addProduct(Product product);

	public boolean updateProduct(Product product);

	public boolean removeProduct(Long id);
}
