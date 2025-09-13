package org.ninjabrand.controller;

import org.ninjabrand.dto.CategoryDTO;
import org.ninjabrand.dto.ProductDTO;
import org.ninjabrand.model.Category;
import org.ninjabrand.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1.0/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public Category createCategory(
            @RequestBody CategoryDTO categoryDTO
    ) {
        return categoryService.createCategory(categoryDTO);
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategoryById(@PathVariable("id") Long id) {
        return categoryService.getCategory(id);
    }

    @GetMapping
    public List<Category> getCategories() {
        return categoryService.findAllCategories();
    }

    @PutMapping("/{id}")
    public Category updateCategory(
            @PathVariable("id") Long id,
            @RequestBody CategoryDTO categoryDTO, ProductDTO productDTO
    ) {
        return categoryService.updateCategory(id, categoryDTO, productDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(
            @PathVariable("id") Long id
    ) {
        return categoryService.deleteCategory(id);
    }
}
