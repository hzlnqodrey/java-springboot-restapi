package com.domain.models.repos;

// DAO [Data Access Object ->  is a object/interface, which is used to access data from database of data storage.]

import org.springframework.data.repository.CrudRepository; // extends Interface repository yg dimiliki oleh Java
import com.domain.models.entities.Product; // import Product model/entities

public interface ProductRepo extends CrudRepository<Product, Long> {
    
}
