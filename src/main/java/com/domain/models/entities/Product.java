package com.domain.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id; // for primary key
import javax.persistence.GeneratedValue; // for generate autoincrement id
import javax.persistence.GenerationType; // data type for id
import javax.persistence.Table;

@Entity // sebuah entity class harus dianotasi sebagai entity
@Table(name = "tbl_product") // optional, but it can help naming the jpa to the mysql demoapi table product
public class Product implements Serializable {
    
    // Serial Version
    private static final long serialVersionUID = 1L;

    // DEFINISI FIELD
    // PRIMARY KEY [harus anotasi memakai Id]
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="product_name", length=100)
    private String name;

    @Column(name="product_description", length=500)
    private String description;

    // default
    private Double price;

    // Constructor
    public Product(Long id, String name, String description, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }


    // SETTER GETTER
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
