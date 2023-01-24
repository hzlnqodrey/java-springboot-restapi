package com.domain.services;
// CLASS SERVICE
// biasanya di apps complex, class service berisi Business Logic
// misalnya:
// 1. Business Process untuk Transfer [Rekening A -> Rekening B]
// nah flow untuk mengimplement transfer itu akan ada di class2 service
// akan dicek data transaksi, cek tabel, cek field, cek saldo dkk (gitulah pokoknya)

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.models.entities.Product;
import com.domain.models.repos.ProductRepo;

@Service
@Transactional
public class ProductService {
    
    // Inject ProductService into ProductRepo
    @Autowired // mengasih dependensi injection
    private ProductRepo productRepo;

    // Simpan/Create Product
    public Product save(Product product) {
        return productRepo.save(product);
    }

    // Find One (Read One Product by ID)
    public Product findOne(Long id) {
        
        // Handling if the requested ID is not found in DATABASE
        // Use Optional Object untuk error handling
        Optional<Product> product = productRepo.findById(id);

        if ( !product.isPresent() ) {
            return null;
        }

        return product.get();
    }

    // Find All (Read All Products)
    public Iterable<Product> findAll() {
        return productRepo.findAll();
    }

    // Remove One (Delete One Product by ID)
    public void removeOne(Long id) {
        productRepo.deleteById(id);
    }

    // Search Product by Name
    public List<Product> findByName(String name) {
        return productRepo.findByNameContains(name);
    }

}
