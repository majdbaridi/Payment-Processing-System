package com.majd.finance.DTO;

import com.majd.finance.entity.PaymentMethod;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TransactionResponse {
    private Long id;
    private Long userId;
    private String recipient;
    private Double amount;
    private String currency;
    private String status;
    private PaymentMethod paymentMethod;
    private LocalDateTime createdAt;
}
