package com.cnpm.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cnpm.dto.CustomerDTO;
import com.cnpm.entity.CustomerEntity;
import com.cnpm.entity.PostEntity;
import com.cnpm.repository.CustomerRepository;
import com.cnpm.repository.PostRepository;
import com.cnpm.service.iCustomerService;

@CrossOrigin
@RestController
public class CustomerAPI {
	
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	private iCustomerService customerService;

	@PostMapping(value = "/customer")
	public CustomerDTO createCustomer(@RequestBody CustomerDTO model) {
		return customerService.save(model);
	}
	@GetMapping(value = "/customer/search")
    public ResponseEntity<List<CustomerEntity>> searchCustomer(@Valid CustomerEntity customers) {
        List<CustomerEntity> all = customerRepository.findAll(Example.of(customers));
        return ResponseEntity.ok(all);
    }


}
