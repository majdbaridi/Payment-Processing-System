package com.majd.finance.repository;

import com.majd.finance.entity.RecurringPayment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecurringPaymentRepository extends JpaRepository<RecurringPayment, Long> {
    List<RecurringPayment> findAllByUserId(Long userId);
}
