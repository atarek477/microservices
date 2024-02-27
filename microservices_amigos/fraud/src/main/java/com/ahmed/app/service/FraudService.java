package com.ahmed.app.service;

import com.ahmed.app.model.Fraud;
import com.ahmed.app.repository.FraudRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudService {

    private final FraudRepository fraudRepository;



    public Boolean isFraudCheck(Integer customerId){
        fraudRepository.save(
                Fraud.builder()
                        .isFraudster(false)
                        .customerId(customerId)
                        .createdAt(LocalDateTime.now())
                        .build()
        );

        return false;
    }




}
