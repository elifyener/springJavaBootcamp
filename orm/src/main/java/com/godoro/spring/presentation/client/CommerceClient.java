package com.godoro.spring.presentation.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.godoro.spring.business.dto.ProductDto;

@Controller
public class CommerceClient {

	@Autowired
	private ProductClient productClient;
	
	@GetMapping("/product/get")
	@ResponseBody
	public String getProduct() {
		long productId = 301;
		ProductDto productDto = productClient.getProduct(productId);
		System.out.println("Ürün: " + productDto.getProductName());
		return "Edinme Basarili " + productDto.getProductName() + " " + productDto.getSalesPrice();
	}
	
	@GetMapping("/product/post")
	@ResponseBody
	public String postProduct() {
		ProductDto productDto = new ProductDto(0, "Fritöz", 540);
		String url = "http://localhost:8080/api/product"; 
		RestTemplate restTemplate = new RestTemplate();
		ProductDto result = restTemplate.postForObject(url, productDto, ProductDto.class);
		return "Yollama Basarili " + result.getProductId();
	}
	
	@GetMapping("/product/put")
	@ResponseBody
	public String putProduct() {
		ProductDto productDto = new ProductDto(302, "Tablet Bilgisayar", 5465);
		String url = "http://localhost:8080/api/product"; 
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<ProductDto>(productDto), Void.class);
		return "Güncelleme Basarili ";
	}
	
	@GetMapping("/product/delete")
	@ResponseBody
	public String deleteProduct() {
		long productId = 303;
		String url = "http://localhost:8080/api/product/" + productId; 
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(url);
		return "Silme Basarili ";
	}
}
