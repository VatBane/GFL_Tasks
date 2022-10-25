package com.example.converter.RESTControllers;

import com.example.converter.entities.Category;
import com.example.converter.entities.Convertation;
import com.example.converter.exceptions.DuplicateException;
import com.example.converter.exceptions.ResourceNotFoundException;
import com.example.converter.repositories.CategoryRepository;
import com.example.converter.repositories.ConvertationRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/category")
public class CategoryRESTController {
    private final CategoryRepository categoryRepository;
    private final ConvertationRepository convertationRepository;

    public CategoryRESTController(CategoryRepository categoryRepository, ConvertationRepository convertationRepository) {
        this.categoryRepository = categoryRepository;
        this.convertationRepository = convertationRepository;
    }

    @GetMapping(path = "")
    public ResponseEntity<Iterable<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryRepository.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable String id) {
        Category category = categoryRepository.findById(Integer.parseInt(id))
                .orElseThrow(() -> new ResourceNotFoundException("Нет такой категории!"));
        return ResponseEntity.ok(category);
    }

    @PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Category createCategory(@RequestBody Category category) {
        if (category.getTitle() == null) {
            throw new IllegalArgumentException("Нет названия!!!");
        }
        if (categoryRepository.findCategoryByTitle(category.getTitle()).isPresent()) {
            throw new DuplicateException("Уже есть такая категория");
        }
        if (category.getId() != null)
            if (categoryRepository.findById(category.getId()).isPresent())
                throw new DuplicateException("Уже есть такая категория");
        else
            category.setCount(0);
        return categoryRepository.save(category);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Category updateCategory(@PathVariable Integer id, @RequestBody Category category) {
        System.out.println("called");
        Optional<Category> c = categoryRepository.findById(id);
        Category oldCategory;
        if (c.isPresent()) {
            oldCategory = c.get();
            category.setId(oldCategory.getId());
            category.setCount(oldCategory.getCount());
        } else
            throw new ResourceNotFoundException("Нет такой категории");
        return categoryRepository.save(category);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCategory(@PathVariable Integer id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Нет такой категории!"));
        List<Convertation> convertations = convertationRepository.getConvertationsByCategoryId(id);
        convertationRepository.deleteAll(convertations);
        categoryRepository.deleteById(id);
    }
}
