package com.ty.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ty.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{
	 List<Product> findProductByProdName(String prodName); 
}
