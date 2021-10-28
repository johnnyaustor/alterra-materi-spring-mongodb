package com.alterra.springmongo;

import com.alterra.springmongo.model.Product;
import com.alterra.springmongo.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Log4j2
@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    public void testCreate() {
        Product product = new Product();
        product.setName("Balon");
        product.setQty(50);
        product.setPrice(500f);
        productService.create(product);
    }

    @Test
    public void testGetList() {
        List<Product> all = productService.findAll();
        all.forEach(log::info);
    }

    @Test
    public void testGetDetail_notFound() {
        try {
            Product product = productService.findById("61618b469c9c0358f15bd69b");
            log.info(product);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
    }

    @Test
    public void testGetDetail() {
        try {
            Product product = productService.findById("61618b469c9c0358f15bd65b");
            log.info(product);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
    }

    @Test
    public void testDelete_notFound() {
        try {
            productService.delete("61618b469c9c0358f15bd69b");
            log.info("product deleted");
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
    }

    @Test
    public void testDelete() {
        try {
            productService.delete("61618b469c9c0358f15bd65b");
            log.info("product deleted");
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
    }
}
