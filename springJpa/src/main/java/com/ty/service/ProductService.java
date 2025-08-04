package com.ty.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.entity.Product;
import com.ty.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;
	
	public Product save(Product p) {
		Product save = repo.save(p);
		return save;
	}
	
//	findAll
	public Iterable<Product> getAll(){
		return repo.findAll();
	}
	
//	findOne
	public Optional<Product> FindProductById(int id) {
		return repo.findById(id);
	}
	
	public void delete(int id) {
		Optional<Product> p=repo.findById(id);
		Product pro=p.get();
		repo.delete(pro);
	}

}

