package com.alterra.springmongo;

import com.alterra.springmongo.model.Product;
import com.alterra.springmongo.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductTest {

    @Mock
    private ProductRepository productRepository;

    @Test
    public void testCreateProduct() {
        Product product = new Product();
        product.setName("Balon");
        product.setQty(50);
        product.setPrice(500f);
        productRepository.save(product);
    }
}
