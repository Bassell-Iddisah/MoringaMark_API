package org.ninjabrand.service.impl;

import org.ninjabrand.dto.ProductDTO;
import org.ninjabrand.exceptions.ResourceNotFoundException;
import org.ninjabrand.model.Product;
import org.ninjabrand.repository.ProductRepository;
import org.ninjabrand.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepo;

    @Override
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Cannot find product with Id: " + id));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product updateProduct(Long id, Product productt) {
        Product product = productRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Cannot find product with Id: " + id));
        if(product != null) {
            product.setName(productt.getName());
            product.setDesc(productt.getDesc());
            product.setPrice(productt.getPrice());
//            product.setCategory(productDTO.category);
            return productRepo.save(product);
        } else {
            return new Product();
        }
    }

    @Override
    public String deleteProductById(Long id) {
        productRepo.deleteById(id);
        return "Product Deleted";
    }
}