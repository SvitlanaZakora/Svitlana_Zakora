package com.epam.spring.homework4.repository;

import com.epam.spring.homework4.model.Receipt;

import java.util.List;

public interface ReceiptRepository {
    Receipt createReceipt(int userId);
    boolean deleteReceiptById(int id);
    Receipt getReceiptById(int receiptId);
    List<Receipt> getAllReceiptsByUserIdAndActive(int userId, boolean active);
    boolean closeReceipt(int receiptId, double total);
}
