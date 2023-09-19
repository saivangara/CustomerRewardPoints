package com.charter.CustomerRewards.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.charter.CustomerRewards.model.Transaction;

@Repository
@Transactional
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    
    public List<Transaction> findByCustomerIdAndTransactionDateBetween(Long customerId, LocalDate from, LocalDate to);
}
