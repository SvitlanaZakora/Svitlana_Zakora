package com.epam.spring.homework4.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {
    private int id;
    private String name;
    private String capacityType;
    private double capacity;
    private double price;
    private String code;
}
