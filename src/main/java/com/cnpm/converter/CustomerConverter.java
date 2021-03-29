package com.cnpm.converter;

import org.springframework.stereotype.Component;

import com.cnpm.dto.CustomerDTO;
import com.cnpm.entity.CustomerEntity;

@Component
public class CustomerConverter {

	public CustomerEntity toEntity(CustomerDTO dto) {
		CustomerEntity entity = new CustomerEntity();
		entity.setEmail(dto.getEmail());
		entity.setPassword(dto.getPassword());
		entity.setName(dto.getName());
		entity.setPhoneNumber(dto.getPhoneNumber());
		entity.setType(dto.getType());
		return entity;
	}

	public CustomerDTO toDTO(CustomerEntity entity) {
		CustomerDTO dto = new CustomerDTO();
		if(entity.getId()!=null) {
			dto.setId(entity.getId());
		}
		dto.setEmail(entity.getEmail());
		dto.setPassword(entity.getPassword());
		dto.setName(entity.getName());
		dto.setPhoneNumber(entity.getPhoneNumber());
		dto.setType(entity.getType());
		return dto;
	}

	public CustomerEntity toEntity(CustomerDTO dto, CustomerEntity entity) {

		entity.setEmail(dto.getEmail());
		entity.setPassword(dto.getPassword());
		entity.setName(dto.getName());
		entity.setPhoneNumber(dto.getPhoneNumber());
		entity.setType(dto.getType());
		return entity;
	}
}
