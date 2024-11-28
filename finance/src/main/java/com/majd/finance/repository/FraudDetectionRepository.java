package com.majd.finance.repository;

import com.majd.finance.entity.FraudDetection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudDetectionRepository extends JpaRepository<FraudDetection, Long> {
}
