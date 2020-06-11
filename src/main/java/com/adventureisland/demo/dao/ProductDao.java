package com.adventureisland.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.adventureisland.demo.model.Product;
import com.adventureisland.demo.model.QueryParameter;

@Mapper
public interface ProductDao {
	
	public Long getMaxProductId();

	public List<Product> getAllProducts();
	
	public List<Product> getAllProductsInfo();

	public Product getProductById(Long id);
	
	public Product getProductInfoById(Long id);
	
	public List<Product> getProductInfoByName(String name);
	
	public List<Product> getProductPriceTrend(QueryParameter queryParameter);
	
	public void insertProduct(Product product);
	
	public void insertProductPrice(Product product);
	
	public void insertProductStock(Product product);

	public void updateProduct(Product product);
	
	public void updateProductPrice(Product product);
	
	public void updateProductStock(Product product);

	public void deleteProduct(Long id);
	
	public void deleteProductPrice(Long productId);
	
	public void deleteProductStock(Long productId);
}
