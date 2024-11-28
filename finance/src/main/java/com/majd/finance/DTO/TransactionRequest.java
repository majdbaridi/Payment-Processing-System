package com.majd.finance.DTO;

import com.majd.finance.entity.PaymentMethod;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class TransactionRequest {
    private Long userId;
    private String recipient;
    private Double amount;
    private String currency;
    private PaymentMethod paymentMethod;
}
