package com.charter.CustomerRewards.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "transaction_date")
    private Date transactionDate;

    @Column(name = "amount")
    private double transactionAmount;
    
    public int calculateRewardPoints() {
        int points = 0;
        if (transactionAmount > 100) {
            points += 2 * ((int) (transactionAmount - 100));
        }
        if (transactionAmount > 50) {
            points += (int) (transactionAmount - 50);
        }
        return points;
    }
}
