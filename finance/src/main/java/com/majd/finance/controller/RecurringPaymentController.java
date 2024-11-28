package com.majd.finance.controller;

import com.majd.finance.DTO.RecurringPaymentRequest;
import com.majd.finance.DTO.RecurringPaymentResponse;
import com.majd.finance.service.RecurringPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recurring-payments")
@RequiredArgsConstructor
public class RecurringPaymentController {

    private final RecurringPaymentService recurringPaymentService;

    @PostMapping
    public ResponseEntity<RecurringPaymentResponse> createRecurringPayment(@RequestBody RecurringPaymentRequest request) {
        return ResponseEntity.ok(recurringPaymentService.createRecurringPayment(request));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RecurringPaymentResponse>> getUserRecurringPayments(@PathVariable Long userId) {
        return ResponseEntity.ok(recurringPaymentService.getUserRecurringPayments(userId));
    }

    @PutMapping("/{paymentId}/cancel")
    public ResponseEntity<Void> cancelRecurringPayment(@PathVariable Long paymentId) {
        recurringPaymentService.cancelRecurringPayment(paymentId);
        return ResponseEntity.ok().build();
    }
}
