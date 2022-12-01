package com.vishal.springdata.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vishal.springdata.product.entities.Product;
import com.vishal.springdata.product.repos.ProductRepository;

@SpringBootTest
class ProductDataApplicationTests {
	
	@Autowired
	private ProductRepository productRepository;

	@Test
	void contextLoads() {
		
	}
	
	@Test
	public void testCreate() {
		Product product = new Product();
		product.setId(2);
		product.setName("laptop");
		product.setDesc("lenovo");
		product.setPrice(1000d);
		
		Product savedProduct = productRepository.save(product);
		
		System.out.println("SAVED product to db :: "+savedProduct);
	}
	
	@Test
	public void testRead() {
		Product product = productRepository.findById(2).get();
		System.out.println("product found by id :: "+product);
	}
	
	@Test
	public void testUpdate() {
		Product product = productRepository.findById(2).get();
		product.setPrice(2000d);
		productRepository.save(product);
	}
	
	@Test
	public void getTotalCount() {
		System.out.println("Total count of product object is :: "+productRepository.count());
	}
	

}



//By running this test we can ensure all the config is done properly