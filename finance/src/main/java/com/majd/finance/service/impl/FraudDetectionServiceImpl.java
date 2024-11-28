package com.majd.finance.service.impl;

import com.majd.finance.entity.FraudDetection;
import com.majd.finance.repository.FraudDetectionRepository;
import com.majd.finance.service.FraudDetectionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class FraudDetectionServiceImpl implements FraudDetectionService {

    private final FraudDetectionRepository fraudDetectionRepository;

    @Override
    public boolean isFraudulentTransaction(Double amount, String recipient) {
        // Example rule: Transactions over $10,000 are flagged as fraudulent
        if (amount > 10000) {
            FraudDetection fraudDetection = FraudDetection.builder()
                    .description("Transaction amount exceeds the limit.")
                    .isFraudulent(true)
                    .build();

            fraudDetectionRepository.save(fraudDetection);
            return true;
        }

        // Example rule: Flag if recipient is on a blacklist (hardcoded for demo)
        if (recipient.equalsIgnoreCase("blacklistedRecipient")) {
            FraudDetection fraudDetection = FraudDetection.builder()
                    .description("Recipient is blacklisted.")
                    .isFraudulent(true)
                    .build();

            fraudDetectionRepository.save(fraudDetection);
            return true;
        }

        // No fraud detected
        return false;
    }
}
