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
public class Level1Catching {

	@Autowired
	private ProductRepository repo;
	
	@Autowired
	private EntityManager entityManager;
	
	@Test
	@Transactional   //if this is commented level 1 catche will not work
	public void testCatching() {
		Session session = entityManager.unwrap(Session.class);
		Product product = repo.findById(1).get();
		repo.findById(1);
		
		session.evict(product);  //once evicted next time on wards select query will be executed
		
		repo.findById(1);
	}
}
