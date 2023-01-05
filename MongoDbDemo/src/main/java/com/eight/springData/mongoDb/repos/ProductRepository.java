package com.eight.springData.mongoDb.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eight.springData.mongoDb.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}
