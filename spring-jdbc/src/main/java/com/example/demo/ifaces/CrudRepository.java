package com.example.demo.ifaces;

import java.util.*;

import com.example.demo.model.Customer;

public interface CrudRepository<T> {

	public boolean save(T t);
	public List<Customer> findAll();
	
}
