package com.epam.spring.homework4.controller;

import com.epam.spring.homework4.dto.ProductDto;
import com.epam.spring.homework4.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/product")
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        validateProduct(productDto);
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
        validateProduct(productDto);
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

    private void validateProduct(ProductDto productDto){
        Pattern p = Pattern.compile("\\W");
        Matcher m = p.matcher(productDto.getName());
        String symbols = "";
        while (m.find()) {
            symbols +=  Arrays.toString(m.group().toCharArray());
        }
        if (!symbols.isEmpty())throw new RuntimeException("Incorrect symbols was found " + symbols);

        if (productDto.getCode().toCharArray().length > 4)throw new RuntimeException("Code is invalid");

        if (!productDto.getCapacityType().equals("pcs") && !productDto.getCapacityType().equals("kg")) throw new RuntimeException("Capacity Type is invalid");

        String capacity = Double.toString(productDto.getCapacity());
        if(capacity.matches("[^.1-9]")) throw new RuntimeException("Capacity value is incorrect");

    }
}
