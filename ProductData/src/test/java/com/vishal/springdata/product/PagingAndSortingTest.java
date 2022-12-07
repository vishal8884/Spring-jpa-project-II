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
		Pageable pageable = PageRequest.of(0, 2);    //1 is page number and 2 is page size...page starts with 0
		Page<Product> results = repo.findAll(pageable);
		results.forEach(p -> System.out.println("Paging --- Product name :: "+p.getName()));
	}
	
	
	//---------------------------------------------sorting----------------------------------------------------------------------------------
	
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
	
	
	@Test
	public void testFindAllSortingByNameAndDescription() {
		List<Product> results = repo.findAll(Sort.by("desc","name"));
		System.out.println("results sorting by name and desc:: "+results);
	}
	
	@Test
	public void testFindAllSortingByPriceAndId() {
		List<Product> results = repo.findAll(Sort.by("price","id"));
		System.out.println("results sorting by price and id :: "+results);
	}
	
	
	//---------------------------------------------Paging and sorting--------------------------------------------------------
	
	@Test
	public void testFindAllPagingAndSorting() {
		Pageable pageable = PageRequest.of(0, 2, Direction.DESC,"id");
		repo.findAll(pageable).forEach(p -> System.out.println("Paging and sorting test with id ::"+p));
	}
	
	@Test
	public void testFindAllPagingAndSortingIdAndName() {
		Pageable pageable = PageRequest.of(0, 2, Direction.DESC,"id","name");
		repo.findAll(pageable).forEach(p -> System.out.println("Paging and sorting test with id and name ::"+p));
	}
	
	
	//Custom finder method in repository
	
	@Test
	public void testFindByIdsInWithPaging() {
		List<Product> products = repo.findByIdIn(List.of(1,2,3),PageRequest.of(0, 2));
		System.out.println("products find Ids in with paging :: "+products);
	}
	
	@Test
	public void testFindByIdsInWithPagingAndSorting() {
		List<Product> products = repo.findByIdIn(List.of(1,2,3),PageRequest.of(0, 2,Direction.DESC,"id"));
		System.out.println("products find Ids in with paging and sorting :: "+products);
	}
	
}
