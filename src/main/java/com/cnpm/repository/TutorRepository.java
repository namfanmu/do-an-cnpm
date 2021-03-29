package com.cnpm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cnpm.entity.TutorEntity;

public interface TutorRepository extends JpaRepository<TutorEntity, Long> {
	//Page<TutorEntity> findByPublished(boolean published, Pageable pageable);

	//Page<TutorEntity> findByName(String name, Pageable pageable);

	Page<TutorEntity> findByName(String name, Pageable paging);
}
