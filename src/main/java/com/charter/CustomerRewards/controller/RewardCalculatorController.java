package com.charter.CustomerRewards.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.charter.CustomerRewards.service.RewardCalculatorService;

@CrossOrigin(origins = "*")
@RestController
public class RewardCalculatorController {

    @Autowired
    private RewardCalculatorService rewardCalculatorService;
    
    @GetMapping("transactions/{customerId}")
    public ResponseEntity<Integer> calculateRewardPoints(
            @PathVariable Long customerId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
    	int totalRewardPoint = rewardCalculatorService.calculateRewardPoints(customerId, startDate, endDate);
    	return ResponseEntity.ok(totalRewardPoint); 
    }
}