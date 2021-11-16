package com.epam.spring.homework4.repository;

import com.epam.spring.homework4.model.Product;

import java.util.List;

public interface ProductRepository {
    Product createProduct(Product product);
    Product getProductByName(String name);
    List<Product> getAllProducts();
    Product updateProduct(Product product);
    boolean deleteProduct(int productId);
    Product getProductById(int productId);
    Product getProductByCode(String code);
}
