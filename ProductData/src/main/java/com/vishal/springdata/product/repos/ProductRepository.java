package com.vishal.springdata.product.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import com.vishal.springdata.product.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
