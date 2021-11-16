package com.epam.spring.homework4.service;

import com.epam.spring.homework4.dto.ReceiptDto;

import java.util.List;

public interface ReceiptService {
    ReceiptDto createReceipt(int userId);
    boolean deleteReceiptById(int id);
    ReceiptDto getReceiptById(int receiptId);
    List<ReceiptDto> getAllReceiptsByUserIdAndActive(int userId, boolean active);
    boolean closeReceipt(int receiptId, double total);
}
