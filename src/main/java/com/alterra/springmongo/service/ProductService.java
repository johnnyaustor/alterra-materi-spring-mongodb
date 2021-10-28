package com.alterra.springmongo.service;

import com.alterra.springmongo.model.Product;

import java.util.List;

public interface ProductService {
    Product create(Product product);
    List<Product> findAll();
    Product findById(String id);
    Product update(String id, Product product);
    void delete(String id);
}
