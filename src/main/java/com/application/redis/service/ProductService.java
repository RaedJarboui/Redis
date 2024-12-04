package com.application.redis.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.redis.model.Product;
import com.application.redis.repository.ProductRepository;

import ch.qos.logback.classic.Logger;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;
	
	private final Logger log = (Logger) LoggerFactory.getLogger(ProductService.class);
	
	public Product saveProduct(Product product) {
		return repository.save(product);
	}
	
	public Product findProduct(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public void deleteProduct(int id) {
		Product product = repository.findById(id).orElseThrow(()-> new RuntimeException("no product"));
		repository.delete(product);
	}
	
	

}
