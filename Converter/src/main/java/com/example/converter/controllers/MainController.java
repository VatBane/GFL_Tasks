package com.example.converter.controllers;

import com.example.converter.entities.Category;
import com.example.converter.exceptions.ResourceNotFoundException;
import com.example.converter.repositories.CategoryRepository;
import com.example.converter.repositories.ConvertationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/")
public class MainController {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ConvertationRepository convertationRepository;

    @GetMapping
    public String mainPage(Model model) {
        return "index";
    }

    @GetMapping("categories")
    public String showAllCategories(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "categories";
    }

    @GetMapping("categories/{categoryId}")
    public String showCategory(Model model, @PathVariable Integer categoryId) {
        model.addAttribute("convertations", convertationRepository.getConvertationsByCategoryId(categoryId));
        Category category;
        if (categoryRepository.findById(categoryId).isPresent())
            category = categoryRepository.findById(categoryId).get();
        else
            throw new ResourceNotFoundException("Нет такой категории");
        model.addAttribute("category", category);
        return "convertation";
    }

    @GetMapping("categories/create")
    public String createCategory(Model model) {
        return "create-category";
    }

    @GetMapping("categories/{id}/create")
    public String createConvertation(Model model, @PathVariable Integer id) {
        return "create-convertation";
    }
}
