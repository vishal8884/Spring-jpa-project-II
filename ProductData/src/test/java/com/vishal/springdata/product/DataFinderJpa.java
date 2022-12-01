package com.vishal.springdata.product;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vishal.springdata.product.entities.Product;
import com.vishal.springdata.product.repos.ProductRepository;

@SpringBootTest
public class DataFinderJpa {

	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void testFindByNameId() {
		List<Product> products = productRepository.findByName("laptop");
		Product productsById = productRepository.findById(1).get();
		System.out.println("products found by Name :: "+products);
		System.out.println("products by id :: "+productsById);
	}
	
	
	@Test
	public void testFindByNameAndDesc() {
		List<Product> productsByNameAndDesc = productRepository.findByNameAndDesc("CASIO","digital");
		System.out.println("products by name and desc :: "+productsByNameAndDesc);
	}
}
