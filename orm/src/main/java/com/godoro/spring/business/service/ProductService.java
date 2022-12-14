package com.godoro.spring.business.service;

import java.util.List;

import com.godoro.spring.business.dto.ProductDto;

public interface ProductService {

	long create(ProductDto productDto);
	
	void update(ProductDto productDto);
	
	ProductDto find(long productId);
	
	List<ProductDto> findAll();
	
	void delete(long productId);
}
