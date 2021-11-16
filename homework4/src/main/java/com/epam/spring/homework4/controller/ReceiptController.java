package com.epam.spring.homework4.controller;

import com.epam.spring.homework4.dto.ReceiptDto;
import com.epam.spring.homework4.service.ReceiptService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReceiptController {

    private final ReceiptService receiptService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/receipt/{userId}")
    public ReceiptDto createReceipt(@PathVariable int userId) {
        return receiptService.createReceipt(userId);
    }

    @DeleteMapping(value = "/product/{id}")
    public boolean deleteReceiptById(@PathVariable int id) {
        return receiptService.deleteReceiptById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/receipt/{receiptId}")
    public ReceiptDto getReceiptById(@PathVariable int receiptId) {
        return receiptService.getReceiptById(receiptId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/receipt/{userId}/{active}")
    public List<ReceiptDto> getAllReceiptsByUserIdAndActive(@PathVariable int userId, @PathVariable boolean active) {
        return receiptService.getAllReceiptsByUserIdAndActive(userId,active);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "/receipt/{receiptId}")
    public boolean closeReceipt(@PathVariable int receiptId, double total) {
        return receiptService.closeReceipt(receiptId,total);
    }
}
