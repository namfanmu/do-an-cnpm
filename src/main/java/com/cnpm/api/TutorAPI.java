package com.cnpm.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cnpm.entity.TutorEntity;
import com.cnpm.repository.TutorRepository;

@RestController
@RequestMapping("/api")
public class TutorAPI {

  @Autowired
  TutorRepository tutorRepository;

  @GetMapping("/tutors")
  public ResponseEntity<Map<String, Object>> getAllTutors(
        @RequestParam(required = false) String name,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "3") int size
      ) {

    try {
      List<TutorEntity> tutors = new ArrayList<TutorEntity>();
      Pageable paging = new PageRequest(page, size);
      
      Page<TutorEntity> pageTuts;
      if (name == null)
        pageTuts = tutorRepository.findAll(paging);
      else
        pageTuts = tutorRepository.findByName(name, paging);

      tutors = pageTuts.getContent();

      Map<String, Object> response = new HashMap<>();
      response.put("tutors", tutors);
      response.put("currentPage", pageTuts.getNumber());
      response.put("totalItems", pageTuts.getTotalElements());
      response.put("totalPages", pageTuts.getTotalPages());

      return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
}
