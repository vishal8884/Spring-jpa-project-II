package com.vishal.springdata.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
		
		productRepository.save(product);
	}
	
	@Test
	public void testRead() {
		Product product = productRepository.findById(2).get();
		assertNotNull(product);
		assertEquals("laptop", product.getName());
	}
	
	@Test
	public void testUpdate() {
		Product product = productRepository.findById(2).get();
		product.setPrice(2000d);
		productRepository.save(product);
	}

}



//By running this test we can ensure all the config is done properly