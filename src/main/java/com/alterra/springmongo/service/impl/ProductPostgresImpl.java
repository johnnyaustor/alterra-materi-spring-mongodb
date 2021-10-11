package com.alterra.springmongo.service.impl;

import com.alterra.springmongo.model.Product;
import com.alterra.springmongo.service.ProductService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("postgres")
public class ProductPostgresImpl implements ProductService {

    @Override
    public String hello() {
        return "hello postgres";
    }

    @Override
    public Product create(Product product) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Product findById(String id) {
        return null;
    }

    @Override
    public Product update(String id, Product product) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
