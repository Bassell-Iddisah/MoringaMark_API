package org.ninjabrand.service;

import org.ninjabrand.dto.ProductDTO;
import org.ninjabrand.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    Product createProduct(ProductDTO productDTO);
    Product getProductById(Long id);
    List<Product> getAllProducts();
    Product updateProduct(Long id, ProductDTO productDTO);
    String deleteProductById(Long id);
}
