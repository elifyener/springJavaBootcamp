package com.godoro.spring.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.godoro.spring.data.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

	//JPQL
	@Query("select p from Product as p where p.salesPrice >= :minPrice ")
	List<Product> findAllBySalesPriceMin(@Param("minPrice") double minPrice);
}
