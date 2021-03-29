package com.cnpm.converter;

import org.springframework.stereotype.Component;

import com.cnpm.dto.PostDTO;
import com.cnpm.entity.PostEntity;

@Component
public class PostConverter {

	public PostEntity toEntity(PostDTO dto) {
		PostEntity entity = new PostEntity();
		entity.setTitle(dto.getTitle());
		entity.setContent(dto.getContent());

		return entity;
	}

	public PostDTO toDTO(PostEntity entity) {
		PostDTO dto = new PostDTO();
		if(entity.getId()!=null) {
			dto.setId(entity.getId());
		}
		dto.setTitle(entity.getTitle());
		dto.setContent(entity.getContent());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setModifiedDate(entity.getModifiedDate());
		return dto;
	}

	public PostEntity toEntity(PostDTO dto, PostEntity entity) {

		entity.setTitle(dto.getTitle());
		entity.setContent(dto.getContent());

		return entity;
	}
}
