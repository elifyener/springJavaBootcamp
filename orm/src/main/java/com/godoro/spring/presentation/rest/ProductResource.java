package com.godoro.spring.presentation.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.godoro.spring.business.dto.ProductDto;
import com.godoro.spring.business.service.ProductService;

public class ProductResource {

	private ProductService productService;
	
	public ProductResource(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/api/product/{id}")
	public ProductDto getProduct(@PathVariable("id")long productId) {
		ProductDto productDto = productService.find(productId);
		return productDto;
	}
	
	@GetMapping("/api/products")
	public List<ProductDto> getProducts() {
		List<ProductDto> productList = productService.findAll();
		return productList;
	}
	
	@PostMapping("/api/product")
	public ProductDto postProduct(@RequestBody ProductDto productDto) {
		long productId = productService.create(productDto);
		productDto.setProductId(productId);
		return productDto;
	}
	
	@PutMapping("/api/product")
	public void putProduct(@RequestBody ProductDto productDto) {
		productService.update(productDto);
	}
	
	@DeleteMapping("/api/product/{id}")
	public void deleteProduct(@PathVariable("id")long productId) {
		productService.delete(productId);
	}
}
