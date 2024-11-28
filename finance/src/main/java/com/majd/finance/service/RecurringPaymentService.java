package com.majd.finance.service;

import com.majd.finance.DTO.RecurringPaymentRequest;
import com.majd.finance.DTO.RecurringPaymentResponse;

import java.util.List;

public interface RecurringPaymentService {
    RecurringPaymentResponse createRecurringPayment(RecurringPaymentRequest request);
    List<RecurringPaymentResponse> getUserRecurringPayments(Long userId);
    void cancelRecurringPayment(Long paymentId);
}
