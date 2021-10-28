package com.alterra.springmongo.controller;

import com.alterra.springmongo.model.Product;
import com.alterra.springmongo.payload.InternalError;
import com.alterra.springmongo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Product product) {
        Product productCreated = productService.create(product);
        return ResponseEntity.ok(productCreated);
    }

    @GetMapping
    public ResponseEntity<?> listProduct() {
        List<Product> products = productService.findAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> product(@PathVariable("id") String id) {
        try {
            Product product = productService.findById(id);
            return ResponseEntity.ok(product);
        } catch (Exception e) {
            InternalError internalError = new InternalError();
            internalError.setMessage(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody Product product) {
        try {
            Product productUpdated = productService.update(id, product);
            return ResponseEntity.ok(productUpdated);
        } catch (Exception e) {
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        try {
            productService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            InternalError internalError = new InternalError(e.getMessage());
            return ResponseEntity.internalServerError().body(internalError);
        }
    }
}
