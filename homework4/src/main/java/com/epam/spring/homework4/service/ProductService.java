package com.epam.spring.homework4.service;

import com.epam.spring.homework4.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    ProductDto createProduct(ProductDto productDto);
    ProductDto getProductByName(String name);
    List<ProductDto> getAllProducts();
    ProductDto updateProduct(ProductDto productDto);
    boolean deleteProduct(int productId);
    ProductDto getProductById(int productId);
    ProductDto getProductByCode(String code);
}
