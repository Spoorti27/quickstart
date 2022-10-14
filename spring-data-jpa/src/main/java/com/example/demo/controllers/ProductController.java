package com.example.demo.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.Product;
import com.example.demo.services.ProductService;

@RestController
@RequestMapping(path="/api/v1/products")
@CrossOrigin(origins="*")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping
	public List<Product> findAll(){
		
		return this.service.findAll();
	}
	
	@GetMapping(path="/{id}")
	public Product findById(@PathVariable("id") int id) {
		
		return this.service.findById(id).orElseThrow(()-> new RuntimeException("Element Not Found"));
	}
	
	@DeleteMapping(path="/{id}")
	public void deleteById(@PathVariable("id")int id) {
		
		this.service.deleteById(id);
	}
	
	@PostMapping
	public ResponseEntity<Product> add(@RequestBody Product entity) throws URISyntaxException, SQLException{
		
		Product addedEntity=this.service.add(entity);
		int pkey=entity.getId();
		String uri="/api/v1/products/"+pkey;
		return ResponseEntity.created(new URI(uri)).body(addedEntity);
	}
	@GetMapping(path="/srch/{ratePerUnit}")
    public List<Product> findByBranchName(@PathVariable("ratePerUnit")double ratePerUnit){
		return this.service.findByRatePerUnit(ratePerUnit);
	}
	
//	@GetMapping(path="/key/{byPrice}")
//	public List<Product> findByRatePerUnit(@PathVariable("byPrice")double rate){
//		return this.service.findByRatePerUnit(rate);
//	}
	

}
