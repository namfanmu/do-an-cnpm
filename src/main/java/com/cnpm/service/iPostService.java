package com.cnpm.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.cnpm.dto.PostDTO;
import com.cnpm.entity.PostEntity;

public interface iPostService {
	PostDTO save(PostDTO postDTO);
	//PostDTO update(PostDTO postDTO);
	void delete(long[] ids);
	List<PostDTO> findAll(Pageable pageable);
	int totalItem();
	
	
	

}
