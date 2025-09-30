package com.cg.repostitory;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.Product;
public interface ProductRepository extends JpaRepository<Product, Integer> {
	//query method 
	 // findBy<FieldName>
	List<Product> findByProductName(String name);
}
