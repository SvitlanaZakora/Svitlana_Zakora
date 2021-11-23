package com.epam.spring.homework4.controller;

import com.epam.spring.homework4.dto.ProductDto;
import com.epam.spring.homework4.dto.ReceiptDto;
import com.epam.spring.homework4.model.Product;
import com.epam.spring.homework4.model.Receipt;
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
    public ReceiptDto save(@PathVariable int userId) {
        return receiptService.save(userId);
    }

    @DeleteMapping(value = "/product/{id}")
    public boolean delete(@PathVariable int id) {
        return receiptService.delete(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/receipt/{receiptId}")
    public ReceiptDto getById(@PathVariable int receiptId) {
        return receiptService.getById(receiptId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/receipt/{userId}/{active}")
    public List<ReceiptDto> findAllByUserIdAndActive(@PathVariable int userId, @PathVariable boolean active) {
        return receiptService.findAllByUserIdAndActive(userId,active);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "/receipt/{receiptId}")
    public ReceiptDto closeReceipt(@PathVariable int receiptId) {
        return receiptService.closeReceipt(receiptId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "/receipt/addProduct/{receiptId}")
    public ReceiptDto addProductToReceipt(@RequestBody ProductDto productDto, @PathVariable int receiptId) {
        return receiptService.addProductToReceipt(productDto,receiptId);
    }
}
