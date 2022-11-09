package com.godoro.spring.presentation.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.godoro.spring.business.dto.ProductDto;


@Component
public class ProductClient {

	public ProductDto getProduct(long productId) {
		String url = "http://localhost:8080/api/product/" + productId ; 
		RestTemplate restTemplate = new RestTemplate();
		ProductDto productDto = restTemplate.getForObject(url, ProductDto.class);
		return productDto;
	}
}
