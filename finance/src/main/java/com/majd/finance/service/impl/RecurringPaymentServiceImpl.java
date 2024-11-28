package com.majd.finance.service.impl;

import com.majd.finance.DTO.RecurringPaymentRequest;
import com.majd.finance.DTO.RecurringPaymentResponse;
import com.majd.finance.entity.RecurringPayment;
import com.majd.finance.entity.User;
import com.majd.finance.mapper.RecurringPaymentMapper;
import com.majd.finance.repository.RecurringPaymentRepository;
import com.majd.finance.repository.UserRepository;
import com.majd.finance.service.RecurringPaymentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class RecurringPaymentServiceImpl implements RecurringPaymentService {

    private final RecurringPaymentRepository recurringPaymentRepository;
    private final UserRepository userRepository;

    @Override
    public RecurringPaymentResponse createRecurringPayment(RecurringPaymentRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        RecurringPayment payment = RecurringPaymentMapper.toEntity(request, user);
        RecurringPayment savedPayment = recurringPaymentRepository.save(payment);

        return RecurringPaymentMapper.toResponse(savedPayment);
    }

    @Override
    public List<RecurringPaymentResponse> getUserRecurringPayments(Long userId) {
        List<RecurringPayment> payments = recurringPaymentRepository.findAllByUserId(userId);
        return payments.stream()
                .map(RecurringPaymentMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void cancelRecurringPayment(Long paymentId) {
        RecurringPayment payment = recurringPaymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Recurring Payment not found"));
        payment.setActive(false);
        recurringPaymentRepository.save(payment);
    }
}
