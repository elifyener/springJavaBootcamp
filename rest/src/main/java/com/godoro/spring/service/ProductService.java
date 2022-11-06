package com.godoro.spring.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.godoro.spring.Product;

public interface ProductService {

	Product find(long productId);
	List<Product> findAll();
	public void createProduct(Product product);
	public void updateProduct(Product product);
	public void deleteProduct(long productId);
}
