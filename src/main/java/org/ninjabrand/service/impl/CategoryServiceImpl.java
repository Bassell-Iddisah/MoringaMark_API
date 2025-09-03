package org.ninjabrand.service.impl;

import org.ninjabrand.dto.CategoryDTO;
import org.ninjabrand.exceptions.ResourceNotFoundException;
import org.ninjabrand.model.Category;
import org.ninjabrand.repository.CategoryRepository;
import org.ninjabrand.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepo;

    public CategoryServiceImpl(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Category createCategory(CategoryDTO categoryDTO) {
        Category category = Category.builder()
                .name(categoryDTO.name)
                .desc(categoryDTO.desc)
                .build();
        return categoryRepo.save(category);
    }

    @Override
    public Optional<Category> getCategory(Long id) {
        return Optional.of(categoryRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found!")));
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public Category updateCategory(Long id, CategoryDTO categoryDTO) {
        Category category = categoryRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        category.setName(categoryDTO.name);
        category.setDesc(categoryDTO.desc);

        return categoryRepo.save(category);
    }

    @Override
    public String deleteCategory(Long id) {
        categoryRepo.deleteById(id);
        return "Success";
    }
}
