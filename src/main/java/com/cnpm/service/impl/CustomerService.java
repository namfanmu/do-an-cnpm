package com.cnpm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnpm.converter.CustomerConverter;
import com.cnpm.dto.CustomerDTO;
import com.cnpm.entity.CustomerEntity;
import com.cnpm.repository.CustomerRepository;
import com.cnpm.repository.PostRepository;
import com.cnpm.service.iCustomerService;

@Service
public class CustomerService implements iCustomerService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerConverter customerConverter;
	@Override
	public CustomerDTO save(CustomerDTO customerDTO) {
		
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity = customerConverter.toEntity(customerDTO);
		//CustomerEntity customerEntity = customerRepository.findOneByName(postDTO.getCustomerName());
		//customerEntity.set(customerEntity);
		customerEntity = customerRepository.save(customerEntity);
		return customerConverter.toDTO(customerEntity);
	}

}
