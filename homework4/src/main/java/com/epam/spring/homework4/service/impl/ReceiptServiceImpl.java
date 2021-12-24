//package com.epam.spring.homework4.service.impl;
//
//import com.epam.spring.homework4.dto.ProductDto;
//import com.epam.spring.homework4.dto.ReceiptDto;
//import com.epam.spring.homework4.exceptions.NotFoundException;
//import com.epam.spring.homework4.model.Product;
//import com.epam.spring.homework4.model.ProductReceipt;
//import com.epam.spring.homework4.repository.ProductReceiptRepository;
//import com.epam.spring.homework4.repository.ProductRepository;
//import com.epam.spring.homework4.service.ReceiptService;
//import com.epam.spring.homework4.model.Receipt;
//import com.epam.spring.homework4.model.User;
//import com.epam.spring.homework4.repository.ReceiptRepository;
//import com.epam.spring.homework4.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Slf4j
//@Service
//@RequiredArgsConstructor
//public class ReceiptServiceImpl implements ReceiptService {
//
//    @Autowired
//    private final ReceiptRepository receiptRepository;
//
//    @Autowired
//    private final ProductRepository productRepository;
//
//    @Autowired
//    private final ProductReceiptRepository productReceiptRepository;
//
//    @Autowired
//    private final UserRepository userRepository;
//
//    @Override
//    public ReceiptDto save(int userId) {
//        log.info("create receipt with ownerId {}",userId);
//        Receipt receipt = new Receipt();
//        receipt.setUser(userRepository.findById(userId));
//        receipt.setCreationDateTime(LocalDateTime.now());
//        receipt.setActive(true);
//        receiptRepository.save(receipt);
//        return mapReceiptToReceiptDto(receipt);
//    }
//
//    @Override
//    public boolean delete(int id) {
//        log.info("delete receipt with id {}",id);
//        try {
//            receiptRepository.getById(id);
//        }catch (NullPointerException e) {
//            log.error("No product with id " + id);
//            throw new NotFoundException("No product with id " + id);
//        }
//        receiptRepository.deleteById(id);
//        return true;
//    }
//
//    @Override
//    public ReceiptDto getById(int receiptId) {
//        log.info("get receipt by id {} ",receiptId);
//        Receipt receipt = receiptRepository.getById(receiptId);
//        return mapReceiptToReceiptDto(receipt);
//    }
//
//    @Override
//    public List<ReceiptDto> findAllByUserIdAndActive(int userId, boolean active) {
//        log.info("get all receipts by owner id {} and active {} ",userId,active);
//        List<Receipt> receiptList = receiptRepository.findAllByUserIdAndActive(userId,active);
//        return receiptList.stream()
//                .map(this::mapReceiptToReceiptDto)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public ReceiptDto closeReceipt(int receiptId) {
//        log.info("close receipt with id {}",receiptId);
//        Receipt receipt = receiptRepository.getById(receiptId);
//        receipt.setActive(false);
//        receipt.setTotal(receipt.getProducts().stream().map(e->e.getCapacity()*e.getPrice()).reduce(0.0, Double::sum));
//        return mapReceiptToReceiptDto(receiptRepository.save(receipt));
//    }
//
//    @Override
//    public ReceiptDto addProductToReceipt(ProductDto productDto, int receiptId) {
//        Receipt receipt = receiptRepository.findById(receiptId)
//                .orElseThrow(()->new NotFoundException("receipt with id "+receiptId+" not found"));
//        Product dbProduct = productRepository.findByCode(productDto.getCode());
//        ProductReceipt pr = productReceiptRepository.save(ProductReceipt.builder()
//                .capacity(productDto.getCapacity())
//                .price(dbProduct.getPrice())
//                .receipt(receipt)
//                .product(dbProduct)
//                .build());
//        return mapReceiptToReceiptDto(pr.getReceipt());
//    }
//
//    private ReceiptDto mapReceiptToReceiptDto(Receipt receipt){
//        return ReceiptDto.builder()
//                .id(receipt.getId())
//                .creationDateTime(receipt.getCreationDateTime())
//                .total(receipt.getTotal())
//                .active(receipt.isActive())
//                .products(receipt.getProducts().stream().map(e->{
//                    Product p = e.getProduct();
//                    p.setCapacity(e.getCapacity());
//                    p.setPrice(e.getPrice());
//                    return ProductServiceImpl.mapProductToProductDto(p);
//                }).collect(Collectors.toList()))
//                .build();
//    }
//
//    private Receipt mapReceiptDtoToReceipt(ReceiptDto receiptDto){
//        return Receipt.builder()
//                .id(receiptDto.getId())
//                .creationDateTime(receiptDto.getCreationDateTime())
//                .total(receiptDto.getTotal())
//                .active(receiptDto.isActive())
//                .build();
//    }
//}
