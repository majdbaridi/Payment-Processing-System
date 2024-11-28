package com.majd.finance.mapper;

import com.majd.finance.DTO.TransactionRequest;
import com.majd.finance.DTO.TransactionResponse;
import com.majd.finance.entity.Transaction;
import com.majd.finance.entity.User;

public class TransactionMapper {

    /**
     * Maps a TransactionRequest DTO to a Transaction entity.
     *
     * @param request the DTO containing transaction details
     * @param user    the user entity associated with the transaction
     * @return the Transaction entity
     */
    public static Transaction toEntity(TransactionRequest request, User user) {
        return Transaction.builder()
                .user(user)
                .recipient(request.getRecipient())
                .amount(request.getAmount())
                .currency(request.getCurrency())
                .paymentMethod(request.getPaymentMethod())
                .status(com.majd.finance.entity.TransactionStatus.PENDING) // Default to PENDING
                .createdAt(java.time.LocalDateTime.now()) // Set current timestamp
                .build();
    }

    /**
     * Maps a Transaction entity to a TransactionResponse DTO.
     *
     * @param transaction the entity containing transaction details
     * @return the TransactionResponse DTO
     */
    public static TransactionResponse toResponse(Transaction transaction) {
        return TransactionResponse.builder()
                .id(transaction.getId())
                .userId(transaction.getUser().getId())
                .recipient(transaction.getRecipient())
                .amount(transaction.getAmount())
                .currency(transaction.getCurrency())
                .status(transaction.getStatus().name()) // Convert enum to string
                .paymentMethod(transaction.getPaymentMethod()) // Include payment method
                .createdAt(transaction.getCreatedAt())
                .build();
    }
}
