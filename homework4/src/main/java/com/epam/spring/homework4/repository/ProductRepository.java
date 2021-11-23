package com.epam.spring.homework4.repository;

import com.epam.spring.homework4.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findAll();
    Product findByCode(String code);
    Product findByName(String name);
}
