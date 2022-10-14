package com.example.demo.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entity.Product;
import com.example.demo.repos.ProductRepository;

@Service
public class ProductService {
	
	private ProductRepository repo;
    @Autowired
	public ProductService(ProductRepository repo) {
		super();
		this.repo = repo;
	}
	public Product save(Product entity) {
		return this.repo.save(entity);
	}
	public List<Product>findAll(){
		return this.repo.findAll();
	}
	public List<Product>findByProductName(String srchString){
		return this.repo.findByProductName(srchString);
	}
	
	public Optional<Product> findById(int key){
		return this.repo.findById(key);
	}
	public void deleteById(int key) {
		if(this.repo.existsById(key)) {
			this.repo.deleteById(key);
		
		}else {
			throw new RuntimeException("Element not Found");
			
		}
	}
	public Product add(Product entity) throws SQLException {
		return this.repo.save(entity);
		
	}
	public List<Product> findByRatePerUnit(double ratePerUnit){
		return this.repo.findByRatePerUnit(ratePerUnit);
	}

}
