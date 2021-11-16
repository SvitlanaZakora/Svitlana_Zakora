package com.epam.spring.homework4.service.impl;

import com.epam.spring.homework4.dto.ProductDto;
import com.epam.spring.homework4.service.ProductService;
import com.epam.spring.homework4.model.Product;
import com.epam.spring.homework4.model.User;
import com.epam.spring.homework4.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        log.info("create product with name {}",productDto.getName());
        Product product = mapProductDtoToProduct(productDto);
        product = productRepository.createProduct(product);
        return mapProductToProductDto(product);
    }

    @Override
    public ProductDto getProductByName(String name) {
        log.info("get product by name {} ",name);
        Product product = productRepository.getProductByName(name);
        return mapProductToProductDto(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        log.info("get all products");
        return productRepository.getAllProducts().stream()
                .map(this::mapProductToProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        log.info("update product with name {}", productDto.getName());
        Product product = mapProductDtoToProduct(productDto);
        product = productRepository.updateProduct(product);
        return mapProductToProductDto(product);
    }

    @Override
    public boolean deleteProduct(int productId) {
        log.info("delete product with id {}",productId);
        boolean isDeleted = productRepository.deleteProduct(productId);
        return isDeleted;
    }

    @Override
    public ProductDto getProductById(int productId) {
        log.info("get product by id {} ",productId);
        Product product = productRepository.getProductById(productId);
        return mapProductToProductDto(product);
    }

    @Override
    public ProductDto getProductByCode(String code) {
        log.info("get product by code {} ",code);
        Product product = productRepository.getProductByCode(code);
        return mapProductToProductDto(product);
    }

    private ProductDto mapProductToProductDto(Product product){
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .capacity(product.getCapacity())
                .capacityType(product.getCapacityType())
                .price(product.getPrice())
                .build();
    }

    private Product mapProductDtoToProduct(ProductDto productDto){
        return Product.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .capacity(productDto.getCapacity())
                .capacityType(productDto.getCapacityType())
                .price(productDto.getPrice())
                .build();
    }
}
