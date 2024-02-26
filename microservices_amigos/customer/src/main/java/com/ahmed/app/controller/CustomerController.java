package com.ahmed.app.controller;

import com.ahmed.app.model.CustomerRegisterRequest;
import com.ahmed.app.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/customer")
public record CustomerController(CustomerService customerService) {



    @PostMapping("/register")
    public void registerCustomer(@RequestBody CustomerRegisterRequest customerRegisterRequest){

        log.info("new customer register {}",customerRegisterRequest);
        customerService.registerCustomerSevice(customerRegisterRequest);

    }




}
