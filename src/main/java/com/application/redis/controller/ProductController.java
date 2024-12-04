package com.application.redis.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.redis.model.Product;
import com.application.redis.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	@PostMapping("/save")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		 return ResponseEntity.status(HttpStatus.OK).body(product);
		
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> findProduct(@PathVariable int id){
		return Objects.nonNull(service.findProduct(id)) ? ResponseEntity.ok().body(service.findProduct(id)) : ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable int id){
		service.deleteProduct(id);
		return ResponseEntity.noContent().build();
		
	}

}
