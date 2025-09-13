package org.ninjabrand.service;

import org.ninjabrand.dto.CategoryDTO;
import org.ninjabrand.dto.ProductDTO;
import org.ninjabrand.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Category createCategory(CategoryDTO categoryDTO);
    List<Category> findAllCategories();
    Optional<Category> getCategory(Long id);
    Category updateCategory(Long id, CategoryDTO categoryDTO, ProductDTO productDTO);
    String deleteCategory(Long id);
    Category findCategoryByName(String name);
}
