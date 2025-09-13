package org.ninjabrand.service.impl;

import org.ninjabrand.dto.CategoryDTO;
import org.ninjabrand.dto.ProductDTO;
import org.ninjabrand.exceptions.ResourceNotFoundException;
import org.ninjabrand.model.Category;
import org.ninjabrand.model.Product;
import org.ninjabrand.repository.CategoryRepository;
import org.ninjabrand.repository.ProductRepository;
import org.ninjabrand.service.CategoryService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepo;
    private final ProductRepository productRepo;

    public CategoryServiceImpl(CategoryRepository categoryRepo,@Lazy ProductRepository productRepo) {
        this.categoryRepo = categoryRepo;
        this.productRepo = productRepo;
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
    public Category findCategoryByName(String name) {
        return categoryRepo.findByName(name);
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public Category updateCategory(Long id, CategoryDTO categoryDTO, ProductDTO productDTO) {
        Category category = categoryRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        category.setName(categoryDTO.name);
        category.setDesc(categoryDTO.desc);
        if(productDTO != null) {
            Product product = Product.builder()
                    .name(productDTO.name)
                    .desc(productDTO.desc)
                    .build();

            category.addProduct(product);
        }

        return categoryRepo.save(category);
    }

    @Override
    public String deleteCategory(Long id) {
        categoryRepo.deleteById(id);
        return "Success";
    }
}
