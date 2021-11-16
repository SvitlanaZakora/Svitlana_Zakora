package com.epam.spring.homework4.repository.impl;

import com.epam.spring.homework4.model.Product;
import com.epam.spring.homework4.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepositoryImpl implements ProductRepository {

    private final List<Product> list = new ArrayList<>();

    @Override
    public Product createProduct(Product product) {
        list.add(product);
        return product;
    }

    @Override
    public Product getProductByName(String name) {
        return list.stream()
                .filter(product -> product.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product is not found"));
    }

    @Override
    public List<Product> getAllProducts() {
        return list;
    }

    @Override
    public Product updateProduct(Product product) {
        boolean isDeleted = list.removeIf(p -> p.getId() == product.getId());
        if (isDeleted){
            list.add(product);
        }else {
            throw new RuntimeException("Product is not found");
        }
        return product;
    }

    @Override
    public boolean deleteProduct(int productId) {
        return list.removeIf(p -> p.getId() == productId);
    }

    @Override
    public Product getProductById(int productId) {
        return list.stream()
                .filter(product -> product.getId() == productId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product is not found"));
    }

    @Override
    public Product getProductByCode(String code) {
        return list.stream()
                .filter(product -> product.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product is not found"));
    }
}
