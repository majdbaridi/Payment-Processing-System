package com.majd.finance.DTO;

import com.majd.finance.entity.RecurringInterval;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RecurringPaymentRequest {
    private Long userId;
    private String recipient;
    private Double amount;
    private String currency;
    private RecurringInterval interval;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
