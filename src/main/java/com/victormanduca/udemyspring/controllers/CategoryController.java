package com.victormanduca.udemyspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victormanduca.udemyspring.domain.Category;
import com.victormanduca.udemyspring.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {
  
  @Autowired
  private CategoryService service;

  @GetMapping(value = "/{id}")
  public ResponseEntity<?> findOne(@PathVariable Integer id) {
    Category category = service.findById(id);
    
    if (category == null) {
      return ResponseEntity.noContent().build();
    }
    
    return ResponseEntity.ok().body(category);
  }
  
  @PostMapping
  public ResponseEntity<?> create(@RequestBody Category category) {
    Category createdCategory = service.create(category);
    return new ResponseEntity<Category>(createdCategory, HttpStatus.CREATED);
  }
}
