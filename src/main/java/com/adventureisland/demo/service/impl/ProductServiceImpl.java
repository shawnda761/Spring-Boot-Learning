package com.adventureisland.demo.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adventureisland.demo.dao.ProductDao;
import com.adventureisland.demo.model.Catalogue;
import com.adventureisland.demo.model.Product;
import com.adventureisland.demo.model.QueryParameter;
import com.adventureisland.demo.service.CatalogueService;
import com.adventureisland.demo.service.ProductService;

@Service
@Primary
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;

	@Autowired
	CatalogueService catalogueService;

	@Override
	public List<Product> getAllProducts() {
		List<Product> productList = productDao.getAllProducts();
		for (Product product : productList) {
			product.setProductId(product.getId());
			product.setCatalogueName(
					((Catalogue) catalogueService.getCatalogue(product.getCatalogueId()).get(0)).getName());
		}
		return productList;
	}

	@Override
	public List<Product> getAllProductsInfo() {
		List<Product> productInfoList = productDao.getAllProductsInfo();
		for (Product productInfo : productInfoList) {
			productInfo.setProductId(productInfo.getId());
			productInfo.setCatalogueName(
					((Catalogue) catalogueService.getCatalogue(productInfo.getCatalogueId()).get(0)).getName());
		}
		return productInfoList;
	}

	@Override
	public List<Product> getProductById(Long id) {
		Product product = productDao.getProductById(id);
		product.setProductId(product.getId());
		product.setCatalogueName(
				((Catalogue) catalogueService.getCatalogue(product.getCatalogueId()).get(0)).getName());
		return Arrays.asList(product);
	}

	@Override
	public List<Product> getProductInfoById(Long id) {
		Product productInfo = productDao.getProductInfoById(id);
		productInfo.setProductId(productInfo.getId());
		productInfo.setCatalogueName(
				((Catalogue) catalogueService.getCatalogue(productInfo.getCatalogueId()).get(0)).getName());
		return Arrays.asList(productInfo);
	}

	@Override
	public List<Product> getProductInfoByName(String name) {
		List<Product> productInfoList = productDao.getProductInfoByName(name);
		for (Product productInfo : productInfoList) {
			productInfo.setProductId(productInfo.getId());
			productInfo.setCatalogueName(
					((Catalogue) catalogueService.getCatalogue(productInfo.getCatalogueId()).get(0)).getName());
		}
		return productInfoList;
	}

	@Override
	public List<Product> getProductPriceTrend(QueryParameter queryParameter) {
		List<Product> productInfoList = productDao.getProductPriceTrend(queryParameter);
		Product currentProduct = productDao.getProductById(queryParameter.getId());
		((Product) productInfoList.get(0)).setId(currentProduct.getId());
		((Product) productInfoList.get(0)).setProductId(currentProduct.getId());
		((Product) productInfoList.get(0)).setCatalogueId(currentProduct.getCatalogueId());
		((Product) productInfoList.get(0)).setCatalogueName(
				((Catalogue) catalogueService.getCatalogue(((Product) productInfoList.get(0)).getCatalogueId()).get(0))
						.getName());
		((Product) productInfoList.get(0)).setName(currentProduct.getName());
		((Product) productInfoList.get(0)).setComment(currentProduct.getComment());
		return productInfoList;
	}

	@Override
	public boolean addProduct(Product product) {
		productDao.insertProduct(product);
		return true;
	}

	@Override
	public boolean addProductPrice(Product product) {
		productDao.insertProductPrice(product);
		return true;
	}

	@Override
	public boolean addProductStock(Product product) {
		productDao.insertProductStock(product);
		return true;
	}

	@Override
	@Transactional
	public boolean addProductInfo(Product product) {
		productDao.insertProduct(product);
		product.setProductId(productDao.getMaxProductId());
		productDao.insertProductPrice(product);
		productDao.insertProductStock(product);
		return true;
	}

	@Override
	public boolean updateProduct(Product product) {
		productDao.updateProduct(product);
		return true;
	}

	@Override
	public boolean updateProductPrice(Product product) {
		productDao.updateProductPrice(product);
		return true;
	}

	@Override
	public boolean updateProductStock(Product product) {
		productDao.updateProductStock(product);
		return true;
	}

	@Override
	@Transactional
	public boolean updateProductInfo(Product product) {
		productDao.updateProduct(product);
		productDao.updateProductPrice(product);
		productDao.updateProductStock(product);
		return true;
	}

	@Override
	public boolean removeProduct(Long id) {
		productDao.deleteProduct(id);
		return true;
	}

	@Override
	public boolean removeProductPrice(Long productId) {
		productDao.deleteProductPrice(productId);
		return true;
	}

	@Override
	public boolean removeProductStock(Long productId) {
		productDao.deleteProductStock(productId);
		return true;
	}

	@Override
	@Transactional
	public boolean removeProductInfo(Long id) {
		productDao.deleteProduct(id);
		productDao.deleteProductPrice(id);
		productDao.deleteProductStock(id);
		return true;
	}

}
