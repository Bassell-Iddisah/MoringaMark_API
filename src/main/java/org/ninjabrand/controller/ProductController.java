package org.ninjabrand.controller;

import org.ninjabrand.dto.ProductDTO;
import org.ninjabrand.model.Product;
import org.ninjabrand.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/ping")
    public String ping() {
        return "API UP...";
    }

    @PostMapping()
    public ResponseEntity<Product> createProduct(@RequestBody ProductDTO productDTO) {
        Product product = productService.createProduct(productDTO);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(
            @PathVariable("id") Long id) {
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> allProducts = productService.getAllProducts();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable("id") Long id,
            @RequestBody ProductDTO productDTO) {
        Product updatedproduct = productService.updateProduct(id, productDTO);
        return new ResponseEntity<>(updatedproduct, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(
            @PathVariable("id") Long id) {
        String status = productService.deleteProductById(id);
        return new ResponseEntity<>(status, HttpStatus.OK);

    }

}