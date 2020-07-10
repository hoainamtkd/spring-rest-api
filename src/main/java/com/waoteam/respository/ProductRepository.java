package com.waoteam.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.waoteam.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	Product findByName(String name);
}
