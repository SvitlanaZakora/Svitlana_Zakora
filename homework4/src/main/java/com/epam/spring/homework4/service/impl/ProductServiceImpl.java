package com.epam.spring.homework4.service.impl;

import com.epam.spring.homework4.dto.ProductDto;
import com.epam.spring.homework4.exceptions.DublicateEntryException;
import com.epam.spring.homework4.exceptions.NotFoundException;
import com.epam.spring.homework4.service.ProductService;
import com.epam.spring.homework4.model.Product;
import com.epam.spring.homework4.model.User;
import com.epam.spring.homework4.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private final ProductRepository productRepository;

    @Override
    public ProductDto save(ProductDto productDto) {
        log.info("create product with name {}",productDto.getName());
        Product product = mapProductDtoToProduct(productDto);

        try {
            product = productRepository.save(product);
        } catch (DataIntegrityViolationException e) {
            throw new DublicateEntryException("Duplicate entry "+product.getName());
        }
        return mapProductToProductDto(product);
    }

    @Override
    public ProductDto findByName(String name) {
        log.info("get product by name {} ",name);
        Product product = productRepository.findByName(name);
        return mapProductToProductDto(product);
    }

    @Override
    public List<ProductDto> findAll() {
        log.info("get all products");
        return productRepository.findAll().stream()
                .map(ProductServiceImpl::mapProductToProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto update(ProductDto productDto) {
        log.info("update product with name {}", productDto.getName());
        Product product = mapProductDtoToProduct(productDto);
        try {
            productRepository.getById(product.getId());
        }catch (NullPointerException e) {
            log.error("No product " + product.getName());
            throw new NotFoundException("No product " + product.getName());
        }
        productRepository.save(product);
        return mapProductToProductDto(product);
    }

    @Override
    public boolean deleteProduct(int productId) {
        log.info("delete product with id {}",productId);
        try {
            productRepository.getById(productId);
        }catch (NullPointerException e) {
            log.error("No product with id " + productId);
            throw new NotFoundException("No product with id " + productId);
        }
        productRepository.deleteById(productId);
        return true;
    }

    @Override
    public ProductDto getById(int productId) {
        log.info("get product by id {} ",productId);
        Product product = productRepository.getById(productId);
        return mapProductToProductDto(product);
    }

    @Override
    public ProductDto findByCode(String code) {
        log.info("get product by code {} ",code);
        Product product = productRepository.findByCode(code);
        return mapProductToProductDto(product);
    }

    public static ProductDto mapProductToProductDto(Product product){
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .capacity(product.getCapacity())
                .capacityType(product.getCapacityType())
                .price(product.getPrice())
                .code(product.getCode())
                .build();
    }

    private Product mapProductDtoToProduct(ProductDto productDto){
        return Product.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .capacity(productDto.getCapacity())
                .capacityType(productDto.getCapacityType())
                .price(productDto.getPrice())
                .code(productDto.getCode())
                .build();
    }
}
