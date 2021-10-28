package com.alterra.springmongo.service.impl;

import com.alterra.springmongo.model.Product;
import com.alterra.springmongo.repository.ProductRepository;
import com.alterra.springmongo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(String id) {
        return productRepository.findById(id).orElseThrow(()->{
            throw new RuntimeException("Not Found");
        });
    }

    @Override
    public Product update(String id, Product product) {
        Product productById = this.findById(id);
        productById.setName(product.getName());
        productById.setPrice(product.getPrice());
        productById.setQty(product.getQty());
        return productRepository.save(productById);
    }

    @Override
    public void delete(String id) {
        Product product = this.findById(id);
        productRepository.delete(product);
    }
}
