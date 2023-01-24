package com.domain.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.models.entities.Product;
import com.domain.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    // Inject Product Service into Product Controller
    // Intinya MVC
    // Product Controller -> (memanggil) Service -> (memanggil) repository -> (memanggil) entities
    @Autowired 
    private ProductService productService;

    //=== ENDPOINT PRODUCT

    //=== 1. Save/Insert/Create Product
    // Argumen dalam BODY REQUEST, kasih anotasi request body ke params
    @PostMapping
    public Product create(@RequestBody Product product) {
        System.out.println("Creating product...");
        return productService.save(product);
    }

    //=== 2. Find All Products
    @GetMapping
    public Iterable<Product> findAll() {
        System.out.println("Fetching all products...");
        return productService.findAll();
    }

    //=== 3. Find One Product by Id
    @GetMapping("/{id}")
    public Product findOne(@PathVariable("id") Long id) {
        System.out.println("Fetching product...");
        return productService.findOne(id);
    }

    //=== 4. Update One Produdct by Id
    @PutMapping
    public Product update(@RequestBody Product product) {
        System.out.println("Updating product...");
        return productService.save(product);
    }

    
}
