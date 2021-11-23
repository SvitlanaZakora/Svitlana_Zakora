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
    public ProductDto save(@RequestBody ProductDto productDto) {
        validateProduct(productDto);
        return productService.save(productDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/product/name/{name}")
    public ProductDto findByName(@PathVariable String name) {
        return productService.findByName(name);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/product")
    public List<ProductDto> findAllProducts() {
        return productService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/product")
    public ProductDto update(@RequestBody ProductDto productDto) {
        validateProduct(productDto);
        return productService.update(productDto);
    }


    @DeleteMapping(value = "/product/id/{productId}")
    public boolean delete(@PathVariable int productId) {
        return productService.deleteProduct(productId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/product/id/{productId}")
    public ProductDto getById(@PathVariable int productId) {
        return productService.getById(productId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/product/code/{code}")
    public ProductDto findByCode(@PathVariable String code) {
        return productService.findByCode(code);
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
