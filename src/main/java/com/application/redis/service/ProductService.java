package com.application.redis.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.application.redis.model.Product;
import com.application.redis.repository.ProductRepository;

import ch.qos.logback.classic.Logger;

@Service
public class ProductService {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ProductService.class);
	@Autowired
	private ProductRepository repository;
	
	private final Logger log = (Logger) LoggerFactory.getLogger(ProductService.class);
	public Product saveProduct(Product product) {
		return repository.save(product);
	}
	
	@Cacheable(value="Product",key="#id")
	public Product findProduct(int id) {
		logger.info("fetch from DB");
		return repository.findById(id).orElse(null);
	}
	@CacheEvict(value="Product",key="#id")
	public void deleteProduct(int id) {
		Product product = repository.findById(id).orElseThrow(()-> new RuntimeException("no product"));
		repository.delete(product);
	}
	
	

}
