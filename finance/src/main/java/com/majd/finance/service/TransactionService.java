package com.majd.finance.service;

import com.majd.finance.DTO.TransactionRequest;
import com.majd.finance.DTO.TransactionResponse;

import java.util.List;

public interface TransactionService {
    TransactionResponse createTransaction(TransactionRequest request);
    List<TransactionResponse> getUserTransactions(Long userId);
}
