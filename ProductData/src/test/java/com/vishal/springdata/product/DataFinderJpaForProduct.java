package com.vishal.springdata.product;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vishal.springdata.product.entities.Product;
import com.vishal.springdata.product.repos.ProductRepository;

@SpringBootTest
public class DataFinderJpaForProduct {

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
	
	@Test
	public void testFindByPriceGreaterThan() {
		List<Product> products = productRepository.findByPriceGreaterThan(1000d);
		System.out.println("products greater than 100 :: "+products);
	}
	
	@Test
	public void testFindByDescContains() {
		List<Product> products = productRepository.findByDescContains("dig");
		System.out.println("products find by desc:: "+products);
	}
	
	@Test
	public void testFindByPriceBetween() {
		List<Product> products = productRepository.findByPriceBetween(10d,500d);
		System.out.println("products find price between 10 and 500d:: "+products);
	}
	
	@Test
	public void testFindByDescLike() {
		List<Product> products = productRepository.findByDescLike("%nov%");
		System.out.println("products find desc like :: "+products);
	}
	
	@Test
	public void testFindByIdsIn() {
		List<Product> products = productRepository.findByIdIn(List.of(1,2,3));
		System.out.println("products find Ids in :: "+products);
	}
}
