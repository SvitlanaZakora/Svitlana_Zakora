package com.epam.spring.homework4.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ReceiptDto {
    private int id;
    private LocalDateTime creationDateTime;
    private List<ProductDto> products;
    private double total;
    private boolean active;
}
