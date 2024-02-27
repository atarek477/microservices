package com.ahmed.app.service;

import com.ahmed.app.model.FraudResponse;
import com.ahmed.app.repository.CustomerRepository;
import com.ahmed.app.model.Customer;
import com.ahmed.app.model.CustomerRegisterRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;



    public void registerCustomerSevice(CustomerRegisterRequest customerRegisterRequest) {
        Customer customer= Customer.builder()
                .firstname(customerRegisterRequest.firstname())
                .lastname(customerRegisterRequest.lastname())
                .email(customerRegisterRequest.email())
                .build();


               customerRepository.saveAndFlush(customer);

        FraudResponse fraudResponse = restTemplate.getForObject("http://localhost:7677/api/v1/fraud/{customerId}", FraudResponse.class, customer.getId());
              if (fraudResponse.isFraudster())
              {
                  throw new IllegalStateException("isFraudster");
              }

    }
}
