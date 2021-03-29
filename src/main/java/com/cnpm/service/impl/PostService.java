package com.cnpm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cnpm.converter.PostConverter;
import com.cnpm.dto.PostDTO;
import com.cnpm.entity.CustomerEntity;
import com.cnpm.entity.PostEntity;
import com.cnpm.repository.CustomerRepository;
import com.cnpm.repository.PostRepository;
import com.cnpm.service.iPostService;

@Service
public class PostService implements iPostService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private PostConverter postConverter;

	@Override
	public PostDTO save(PostDTO postDTO) {
		PostEntity postEntity = new PostEntity();
		if (postDTO.getId() != null) {
			PostEntity oldPostEntity = postRepository.findOne(postDTO.getId());
			postEntity = postConverter.toEntity(postDTO, oldPostEntity);
		} else {
			postEntity = postConverter.toEntity(postDTO);
		}
		CustomerEntity customerEntity = customerRepository.findOneByName(postDTO.getCustomerName());
		postEntity.setCustomer(customerEntity);
		postEntity = postRepository.save(postEntity);
		return postConverter.toDTO(postEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item:ids) {
			postRepository.delete(item);
		}
		
	}

	@Override
	public List<PostDTO> findAll(Pageable pageable) {
		List<PostDTO> results=new ArrayList<>();
		List<PostEntity> entities=postRepository.findAll(pageable).getContent();
		for(PostEntity item: entities) {
			PostDTO postDTO=postConverter.toDTO(item);
			results.add(postDTO);
		}
		return results;
	}
	@Override
	public int totalItem() {
		
		return (int) postRepository.count();
	}
	
	/*
	 * @Override public PostDTO update(PostDTO postDTO) { PostEntity oldPostEntity =
	 * postRepository.findOne(postDTO.getId()); PostEntity postEntity =
	 * postConverter.toEntity(postDTO, oldPostEntity); CustomerEntity customerEntity
	 * = customerRepository.findOneByName(postDTO.getCustomerName());
	 * postEntity.setCustomer(customerEntity); postEntity =
	 * postRepository.save(postEntity); return postConverter.toDTO(postEntity); }
	 */
}
