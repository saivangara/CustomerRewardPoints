package com.charter.CustomerRewards.service;

import java.time.LocalDate;

public interface RewardCalculatorService {
    
    public int calculateRewardPoints(Long customerId, LocalDate from, LocalDate to);
}
