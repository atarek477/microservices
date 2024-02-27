package com.ahmed.app.service;

import com.ahmed.app.repository.CustomerRepository;
import com.ahmed.app.model.Customer;
import com.ahmed.app.model.CustomerRegisterRequest;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository) {



    public void registerCustomerSevice(CustomerRegisterRequest customerRegisterRequest) {
        Customer customer= Customer.builder()
                .firstname(customerRegisterRequest.firstname())
                .lastname(customerRegisterRequest.lastname())
                .email(customerRegisterRequest.email())
                .build();
               customerRepository.save(customer);
    }
}
