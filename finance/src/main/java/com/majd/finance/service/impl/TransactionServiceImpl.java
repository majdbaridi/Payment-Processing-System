package com.majd.finance.service.impl;

import com.majd.finance.DTO.TransactionRequest;
import com.majd.finance.DTO.TransactionResponse;
import com.majd.finance.entity.Transaction;
import com.majd.finance.entity.User;
import com.majd.finance.mapper.TransactionMapper;
import com.majd.finance.repository.TransactionRepository;
import com.majd.finance.repository.UserRepository;
import com.majd.finance.service.FraudDetectionService;
import com.majd.finance.service.NotificationProducer;
import com.majd.finance.service.TransactionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final FraudDetectionService fraudDetectionService;
    private final NotificationProducer notificationProducer;

    @Override
    public TransactionResponse createTransaction(TransactionRequest request) {
        // Validate user existence
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Debugging the user object
        System.out.println("Fetched User: " + user);

        // Fraud detection logic
        if (fraudDetectionService.isFraudulentTransaction(request.getAmount(), request.getRecipient())) {
            throw new RuntimeException("Fraudulent transaction detected!");
        }

        // Map DTO to entity
        Transaction transaction = TransactionMapper.toEntity(request, user);

        // Save transaction
        Transaction savedTransaction = transactionRepository.save(transaction);

        // Send notification via RabbitMQ
        notificationProducer.sendNotification("Transaction created for user: " + user.getId());

        // Return response
        return TransactionMapper.toResponse(savedTransaction);
    }

    @Override
    public List<TransactionResponse> getUserTransactions(Long userId) {
        List<Transaction> transactions = transactionRepository.findAllByUserId(userId);
        return transactions.stream()
                .map(TransactionMapper::toResponse)
                .collect(Collectors.toList());
    }
}
