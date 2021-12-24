//package com.epam.spring.homework4.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Data
//@Builder
//@Table(name = "product")
//@AllArgsConstructor
//@NoArgsConstructor
//public class Product {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int id;
//    @Column(unique = true)
//    private String name;
//    private String capacityType;
//    private double capacity;
//    private double price;
//    private String code;
//    @OneToMany(mappedBy = "product")
//    private List<ProductReceipt> receipts;
//}
