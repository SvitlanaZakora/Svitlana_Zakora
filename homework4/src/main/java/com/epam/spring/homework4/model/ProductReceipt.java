package com.epam.spring.homework4.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductReceipt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double capacity;
    private double price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="receipt_id")
    private Receipt receipt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id")
    private Product product;
}
