package com.ty.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;


import com.ty.dto.ResponseStructure;
import com.ty.entity.Product;
import com.ty.repository.ProductRepository;
import com.ty.service.ProductService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/product")
public class ProductController {

	
	@Autowired
	private ProductService service;

    
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Product>> save(@RequestBody Product p) {
		Product save = service.save(p);
		ResponseStructure<Product> resp=new ResponseStructure<>();
		resp.setData(save);
		resp.setMessage("Data Saved");
		return ResponseEntity.ok(resp);
	}
	
	@GetMapping("/fetch")
	public ResponseEntity<ResponseStructure<Iterable<Product>>>  getAll() {
		Iterable<Product> p= service.getAll();
		ResponseStructure<Iterable<Product>> resp=new ResponseStructure<>();
		resp.setMessage("Data Fetched");
		resp.setData(p);
		
		return ResponseEntity.ok(resp);
	}
	
	@GetMapping("/fetch/{id}")
	public ResponseEntity<ResponseStructure<Product>> getProductById(@PathVariable int id) {
		Optional<Product> p= service.FindProductById(id);
		ResponseStructure<Product> resp=new ResponseStructure<>();
		resp.setMessage("Data fetched by id");
		resp.setData(p.get());
		return ResponseEntity.ok(resp);
				}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@PathVariable int id,@RequestBody Product p) {
		Optional<Product> prod=service.FindProductById(id);
		ResponseStructure<Product> resp=new ResponseStructure<>();
		
		if(!prod.isEmpty()) {
			Product pro=prod.get();
			pro.setProdName(p.getProdName());
			pro.setProdCost(p.getProdCost());
			
			Product updated=service.save(pro);
			resp.setMessage("Data Updated");
			resp.setData(updated);
		}
		else {
			resp.setMessage("Not Found");
		}
		return  ResponseEntity.ok(resp);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseStructure<Product>> delete(@PathVariable int id) {
		Optional<Product> p=service.FindProductById(id);
		ResponseStructure< Product> resp=new ResponseStructure<>();
		if(p.isPresent()) {
			service.delete(id);
			
			resp.setMessage("Data deleted");
			resp.setData(p.get());
		}
		else {
			resp.setMessage("not Found");
		}
		
		return ResponseEntity.ok(resp);
	}
	

}
