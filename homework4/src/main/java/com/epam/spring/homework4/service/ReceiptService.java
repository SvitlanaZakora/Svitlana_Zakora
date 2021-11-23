package com.epam.spring.homework4.service;

import com.epam.spring.homework4.dto.ProductDto;
import com.epam.spring.homework4.dto.ReceiptDto;
import com.epam.spring.homework4.model.Product;
import com.epam.spring.homework4.model.Receipt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReceiptService {
    ReceiptDto save(int userId);
    boolean delete(int id);
    ReceiptDto getById(int receiptId);
    List<ReceiptDto> findAllByUserIdAndActive(int userId, boolean active);
    ReceiptDto closeReceipt(int receiptId);
    ReceiptDto addProductToReceipt(ProductDto productDto, int receiptId);
}
