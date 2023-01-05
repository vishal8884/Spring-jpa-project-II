package com.eight.springData.mongoDb;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eight.springData.mongoDb.model.Product;
import com.eight.springData.mongoDb.repos.ProductRepository;

@SpringBootTest
class MongoDbDemoApplicationTests {
	
	@Autowired
	ProductRepository repo;

	@Test
	public void testSave() {
		Product product = Product.builder()
				.name("asus laptop")
				.price(90000f)
				.build();
		
		Product savedProduct = repo.save(product);
		
		System.out.println("savedProduct :: "+savedProduct);
		
		assertNotNull(savedProduct);
	}
	
	@Test
	public void testFindAll() {
		List<Product> products = repo.findAll();
		System.out.println("products :: "+products);
	}
	
	@Test
	public void testUpdate() {
		Product product = repo.findById("63b68e3feecb5e3921257544").get();
		
		product.setName("i phone");
		repo.save(product);
	}

}
