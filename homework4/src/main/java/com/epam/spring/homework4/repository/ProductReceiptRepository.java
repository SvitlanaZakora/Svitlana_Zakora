package com.epam.spring.homework4.repository;

import com.epam.spring.homework4.model.Product;
import com.epam.spring.homework4.model.ProductReceipt;
import com.epam.spring.homework4.model.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReceiptRepository extends JpaRepository<ProductReceipt,Integer> {
}
