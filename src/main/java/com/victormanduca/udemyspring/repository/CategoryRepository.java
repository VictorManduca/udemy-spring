package com.victormanduca.udemyspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.victormanduca.udemyspring.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
