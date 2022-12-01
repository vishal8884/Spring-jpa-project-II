package com.vishal.springdata.product.repos;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vishal.springdata.product.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	List<Product> findByName(String name);
	List<Product> findByNameAndDesc(String name,String desc);
	
}
