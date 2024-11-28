package com.majd.finance.service;

public interface FraudDetectionService {
    boolean isFraudulentTransaction(Double amount, String recipient);
}
