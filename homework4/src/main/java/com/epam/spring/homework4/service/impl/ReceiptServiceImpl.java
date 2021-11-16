package com.epam.spring.homework4.service.impl;

import com.epam.spring.homework4.dto.ReceiptDto;
import com.epam.spring.homework4.service.ReceiptService;
import com.epam.spring.homework4.model.Receipt;
import com.epam.spring.homework4.model.User;
import com.epam.spring.homework4.repository.ReceiptRepository;
import com.epam.spring.homework4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReceiptServiceImpl implements ReceiptService {

    private final ReceiptRepository receiptRepository;

    @Override
    public ReceiptDto createReceipt(int userId) {
        log.info("create receipt with ownerId {}",userId);
        Receipt receipt = receiptRepository.createReceipt(userId);
        return mapReceiptToReceiptDto(receipt);
    }

    @Override
    public boolean deleteReceiptById(int id) {
        log.info("delete receipt with id {}",id);
        boolean isDeleted = receiptRepository.deleteReceiptById(id);
        return isDeleted;
    }

    @Override
    public ReceiptDto getReceiptById(int receiptId) {
        log.info("get receipt by id {} ",receiptId);
        Receipt receipt = receiptRepository.getReceiptById(receiptId);
        return mapReceiptToReceiptDto(receipt);
    }

    @Override
    public List<ReceiptDto> getAllReceiptsByUserIdAndActive(int userId, boolean active) {
        log.info("get all receipts by owner id {} and active {} ",userId,active);
        List<Receipt> receiptList = receiptRepository.getAllReceiptsByUserIdAndActive(userId,active);
        return receiptList.stream()
                .map(this::mapReceiptToReceiptDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean closeReceipt(int receiptId, double total) {
        log.info("close receipt with id {}",receiptId);
        boolean isClosed = receiptRepository.closeReceipt(receiptId,total);
        return isClosed;
    }

    private ReceiptDto mapReceiptToReceiptDto(Receipt receipt){
        return ReceiptDto.builder()
                .id(receipt.getId())
                .creationDateTime(receipt.getCreationDateTime())
                .ownerId(receipt.getOwnerId())
                .ownerName(receipt.getOwnerName())
                .products(receipt.getProducts())
                .total(receipt.getTotal())
                .active(receipt.isActive())
                .build();
    }

    private Receipt mapReceiptDtoToReceipt(ReceiptDto receiptDto){
        return Receipt.builder()
                .id(receiptDto.getId())
                .creationDateTime(receiptDto.getCreationDateTime())
                .ownerId(receiptDto.getOwnerId())
                .ownerName(receiptDto.getOwnerName())
                .products(receiptDto.getProducts())
                .total(receiptDto.getTotal())
                .active(receiptDto.isActive())
                .build();
    }
}
