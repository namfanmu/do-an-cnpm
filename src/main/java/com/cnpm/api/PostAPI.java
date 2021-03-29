package com.cnpm.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cnpm.api.output.PostOutput;
import com.cnpm.dto.PostDTO;
import com.cnpm.entity.PostEntity;
import com.cnpm.repository.PostRepository;
import com.cnpm.service.iPostService;

@CrossOrigin
@RestController
public class PostAPI {
	@Autowired
	PostRepository postRepository;

	@Autowired
	private iPostService postService;

	@PostMapping(value = "/post")
	public PostDTO createPost(@RequestBody PostDTO model) {
		return postService.save(model);
	}

	@PutMapping(value = "/post/{id}")
	public PostDTO updatePost(@RequestBody PostDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return postService.save(model);
	}

	@DeleteMapping(value = "/post")
	public void deletePost(@RequestBody long[] ids) {
		postService.delete(ids);
	}

	@GetMapping(value = "/post")
	public PostOutput showPost(@RequestParam("page") int page, @RequestParam("limit") int limit) {
		PostOutput result = new PostOutput();
		result.setPage(page);
		Pageable pageable = new PageRequest(page - 1, limit);
		result.setListResultDTO(postService.findAll(pageable));
		result.setTotalPage((int) Math.ceil((double) (postService.totalItem()) / limit));
		return result;
	}

	

}
