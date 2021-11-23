package com.epam.spring.homework4.model;

import com.epam.spring.homework4.dto.ProductDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "receipt")
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDateTime creationDateTime;
    private double total;
    private boolean active;
    @OneToMany(mappedBy = "receipt", fetch = FetchType.LAZY)
    private List<ProductReceipt> products;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

}
