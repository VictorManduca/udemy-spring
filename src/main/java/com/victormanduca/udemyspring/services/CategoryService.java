package com.victormanduca.udemyspring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victormanduca.udemyspring.domain.Category;
import com.victormanduca.udemyspring.repository.CategoryRepository;

@Service
public class CategoryService {

  @Autowired
  private CategoryRepository repository;
  
  public Category findById(Integer id) {
      Optional<Category> category = repository.findById(id);
      return category.orElse(null);
  }
  
  public Category create(Category category) {
    Category createdCategory = repository.save(category);
    return createdCategory;
  }
}
