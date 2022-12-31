package com.vishal.springdata.product.repos;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.vishal.springdata.product.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	List<Product> findByName(String name);
	List<Product> findByNameAndDesc(String name,String desc);
	List<Product> findByPriceGreaterThan(Double price);
	List<Product> findByDescContains(String desc);
	List<Product> findByPriceBetween(Double price1, Double price2);
	List<Product> findByDescLike(String desc);
	List<Product> findByIdIn(List<Integer> ids);
	
	//custom finder method for paging
	List<Product> findByIdIn(List<Integer> ids,Pageable pageable);
	
	
}
