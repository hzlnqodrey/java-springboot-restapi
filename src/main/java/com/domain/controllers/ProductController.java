package com.domain.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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

    // ENDPOINT PRODUCT

    public Product create(Product product) {
        return productService.save(product);
    }


}
