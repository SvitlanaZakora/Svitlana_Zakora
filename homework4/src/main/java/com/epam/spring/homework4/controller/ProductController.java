package com.epam.spring.homework4.controller;

import com.epam.spring.homework4.dto.ProductDto;
import com.epam.spring.homework4.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/product")
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/product/{name}")
    public ProductDto getProductByName(@RequestParam String name) {
        return productService.getProductByName(name);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/product")
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/product")
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        return productService.updateProduct(productDto);
    }


    @DeleteMapping(value = "/product/{productId}")
    public boolean deleteProduct(@PathVariable int productId) {
        return productService.deleteProduct(productId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/product/{productId}")
    public ProductDto getProductById(@PathVariable int productId) {
        return productService.getProductById(productId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/product/{code}")
    public ProductDto getProductByCode(@PathVariable String code) {
        return productService.getProductByCode(code);
    }
}
