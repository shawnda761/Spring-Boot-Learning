package com.adventureisland.demo.service;

import java.util.List;

import com.adventureisland.demo.model.Product;
import com.adventureisland.demo.model.QueryParameter;

public interface ProductService {

	public List<Product> getAllProducts();

	public List<Product> getAllProductsInfo();

	public List<Product> getProductById(Long id);
	
	public List<Product> getProductInfoById(Long id);
	
	public List<Product> getProductInfoByName(String name);
	
	public List<Product> getProductPriceTrend(QueryParameter queryParameter);
	
	public boolean addProduct(Product product);
	
	public boolean addProductPrice(Product product);
	
	public boolean addProductStock(Product product);
	
	public boolean addProductInfo(Product product);

	public boolean updateProduct(Product product);
	
	public boolean updateProductPrice(Product product);
	
	public boolean updateProductStock(Product product);
	
	public boolean updateProductInfo(Product product);

	public boolean removeProduct(Long id);
	
	public boolean removeProductPrice(Long productId);
	
	public boolean removeProductStock(Long productId);
	
	public boolean removeProductInfo(Long Id);
}
