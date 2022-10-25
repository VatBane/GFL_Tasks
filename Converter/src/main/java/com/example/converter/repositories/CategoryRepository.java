package com.example.converter.repositories;

import com.example.converter.entities.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

    Optional<Category> findCategoryByTitle(String title);
}
