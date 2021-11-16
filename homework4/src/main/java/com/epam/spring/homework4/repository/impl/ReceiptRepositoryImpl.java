package com.epam.spring.homework4.repository.impl;

import com.epam.spring.homework4.model.Receipt;
import com.epam.spring.homework4.repository.ReceiptRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReceiptRepositoryImpl implements ReceiptRepository {

    private final List<Receipt> list = new ArrayList<>();

    @Override
    public Receipt createReceipt(int userId) {
        Receipt receipt = new Receipt();
        receipt.setOwnerId(userId);
        receipt.setCreationDateTime(LocalDateTime.now());
        list.add(receipt);
        return receipt;
    }

    @Override
    public boolean deleteReceiptById(int id) {
        return list.removeIf(p -> p.getId() == id);
    }

    @Override
    public Receipt getReceiptById(int receiptId) {
        return list.stream()
                .filter(receipt -> receipt.getId() == receiptId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Receipt is not found"));
    }

    @Override
    public List<Receipt> getAllReceiptsByUserIdAndActive(int userId, boolean active) {
        return list.stream()
                .filter(receipt -> receipt.getOwnerId() == userId && receipt.isActive() == active)
                .collect(Collectors.toList());
    }

    @Override
    public boolean closeReceipt(int receiptId, double total) {
        Receipt receipt = list.stream().filter(r -> r.getId() == receiptId && r.isActive() == true)
                .findFirst().get();
        if (receipt != null){
            receipt.setActive(false);
        }else{
            throw new RuntimeException("Opened receipt with id " + receiptId + " not found");
        }
        return true;
    }
}
