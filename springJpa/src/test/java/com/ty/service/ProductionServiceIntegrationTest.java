package com.ty.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ty.entity.Product;
import com.ty.repository.ProductRepository;

@SpringBootTest
public class ProductionServiceIntegrationTest {
	
	@Autowired
	private ProductService service;
	
	@Autowired
	private ProductRepository repo;
	
	@Test
	void testSaveAndDeleteProduct() {
		Product p=new Product();
	
		p.setProdName("integration Product Name");
//		service.save(p);
		
		assertThat(repo.findById(3).isPresent());
		
		service.delete(3);
		
		assertThat(repo.findById(3)).isNotPresent();
	}

	
}
