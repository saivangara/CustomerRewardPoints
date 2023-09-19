package com.charter.CustomerRewards.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charter.CustomerRewards.model.Transaction;
import com.charter.CustomerRewards.repository.TransactionRepository;
import com.charter.CustomerRewards.service.RewardCalculatorService;

@Service
public class RewardCalculatorServiceImpl implements RewardCalculatorService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public int calculateRewardPoints(Long customerId, LocalDate from, LocalDate to) {
    	List<Transaction> transactions = transactionRepository.findByCustomerIdAndTransactionDateBetween(customerId, from, to);
    	int totalPoints = transactions.stream().mapToInt(Transaction::calculateRewardPoints).sum();
    	return totalPoints;
    }
}
