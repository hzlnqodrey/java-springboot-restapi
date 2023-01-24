package com.domain.models.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity // sebuah entity class harus dianotasi sebagai entity
@Table(name = "tbl_product") // optional, but it can help naming
public class Product {
    
}
