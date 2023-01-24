package com.domain.models.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id; // for primary key
import javax.persistence.GeneratedValue; // for generate autoincrement id
import javax.persistence.GenerationType; // data type for id
import javax.persistence.Table;

@Entity // sebuah entity class harus dianotasi sebagai entity
@Table(name = "tbl_product") // optional, but it can help naming the jpa to the mysql demoapi table product
public class Product implements Serializable {
    
    // DEFINISI FIELD

    // PRIMARY KEY [harus anotasi memakai Id]
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Double price;


    // Constructor
    


    // SETTER GETTER

}
