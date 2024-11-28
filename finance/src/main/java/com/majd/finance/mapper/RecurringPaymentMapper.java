package com.majd.finance.mapper;

import com.majd.finance.DTO.RecurringPaymentRequest;
import com.majd.finance.DTO.RecurringPaymentResponse;
import com.majd.finance.entity.RecurringPayment;
import com.majd.finance.entity.User;

public class RecurringPaymentMapper {

    public static RecurringPayment toEntity(RecurringPaymentRequest request, User user) {
        return RecurringPayment.builder()
                .user(user)
                .recipient(request.getRecipient())
                .amount(request.getAmount())
                .currency(request.getCurrency())
                .interval(request.getInterval())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .isActive(true)
                .build();
    }

    public static RecurringPaymentResponse toResponse(RecurringPayment payment) {
        return RecurringPaymentResponse.builder()
                .id(payment.getId())
                .userId(payment.getUser().getId())
                .recipient(payment.getRecipient())
                .amount(payment.getAmount())
                .currency(payment.getCurrency())
                .interval(payment.getInterval())
                .startDate(payment.getStartDate())
                .endDate(payment.getEndDate())
                .isActive(payment.isActive())
                .build();
    }
}
