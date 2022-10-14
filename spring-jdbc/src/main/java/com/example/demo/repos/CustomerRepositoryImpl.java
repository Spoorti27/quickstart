package com.example.demo.repos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.ifaces.CrudRepository;
import com.example.demo.model.Customer;

@Repository
public class CustomerRepositoryImpl implements CrudRepository<Customer> {

	private JdbcTemplate template;
	
	@Autowired
	public CustomerRepositoryImpl(JdbcTemplate template) {
		super();
		this.template = template;
	}

	@Override
	public boolean save(Customer t) {
		
		String sql ="insert into tieto_customer values(?,?,?)";
			 
		
		int rowAdded= 
				template.update(sql,t.getCustomerId(),t.getCustomerName(),t.getEmail());
		
		return rowAdded==1;
	}

	@Override
	public List<Customer> findAll() {
		String sql ="select * from  tieto_customer";
		
		return template.query(sql, BeanPropertyRowMapper.newInstance(Customer.class));
	}

}