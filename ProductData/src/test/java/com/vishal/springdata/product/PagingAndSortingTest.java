package com.vishal.springdata.product;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.vishal.springdata.product.entities.Product;
import com.vishal.springdata.product.repos.ProductRepository;

@SpringBootTest
public class PagingAndSortingTest {

	@Autowired
	ProductRepository repo;
	
	@Test
	public void testFindAllPaging() {
		Pageable pageable = PageRequest.of(1, 2);    //1 is page number and 2 is page size
		Page<Product> results = repo.findAll(pageable);
		
		results.forEach(p -> System.out.println("Paging --- Product name :: "+p.getName()));
	}
	
	@Test
	public void testFindAllSortingByName() {
		List<Product> results = repo.findAll(Sort.by(Direction.ASC,"name"));
		System.out.println("results sorting by name:: "+results);
	}
	
	@Test
	public void testFindAllSortingByDescription() {
		List<Product> results = repo.findAll(Sort.by("desc"));
		System.out.println("results sorting by Desc:: "+results);
	}
}
