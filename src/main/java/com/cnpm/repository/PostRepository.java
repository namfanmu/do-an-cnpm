package com.cnpm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cnpm.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
	

}
