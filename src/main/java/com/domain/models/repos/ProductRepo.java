package com.domain.models.repos;

// DAO [Data Access Object ->  is a object/interface, which is used to access data from database of data storage.]

// Selain Crud Repositor, spring java juga memiliki:
// 1. PagingAndSortingRepository Repository [ref: https://www.baeldung.com/spring-data-jpa-pagination-sorting]
// guna: Pagination dan Sorting SpringData

// 2. JPA Repository
// guna: dapat mewariskan paging and sorting repo + ada fitur2 tambahan 
// misalnya melakukan update secara batching, dan save/create secara bulk/batching

import org.springframework.data.repository.CrudRepository; // extends Interface repository yg dimiliki oleh Java
import com.domain.models.entities.Product; // import Product model/entities

public interface ProductRepo extends CrudRepository<Product, Long> {
    
}
