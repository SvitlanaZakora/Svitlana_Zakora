package com.epam.spring.homework4.model;

import com.epam.spring.homework4.dto.ProductDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Receipt {
    private int id;
    private LocalDateTime creationDateTime;
    private int ownerId;
    private String ownerName;
    private List<ProductDto> products;
    private double total;
    private boolean active;
}
