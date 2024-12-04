package com.application.redis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.redis.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
