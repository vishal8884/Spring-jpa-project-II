package com.vishal.springdata.catcheTest;

import java.util.Optional;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.vishal.springdata.product.entities.Product;
import com.vishal.springdata.product.repos.ProductRepository;

import jakarta.persistence.EntityManager;

@SpringBootTest
public class Level1CatcheTestForProduct {

	@Autowired
	ProductRepository repo;
	
	@Autowired
	EntityManager entityManager; //used internally by spring at run time
	
	@Test
	@Transactional  //if we remove this select query will be executed couple of times...else level1 catche will be in action
	public void testCatching() {
		Session session = entityManager.unwrap(Session.class);
		Product product = repo.findById(1).get();
		repo.findById(1);
		
		session.evict(product);   //removes the product object from level 1 cache....even with evict() level 2 cache will be in action...ie only one select query
		
		repo.findById(1);
	}
}
