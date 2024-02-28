package com.ahmed.app.service;

import com.ahmed.app.fraud.FraudClient;
import com.ahmed.app.fraud.FraudResponse;
import com.ahmed.app.notification.NotificationClient;
import com.ahmed.app.notification.NotificationRequest;
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
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;



    public void registerCustomerSevice(CustomerRegisterRequest customerRegisterRequest) {
        Customer customer= Customer.builder()
                .firstname(customerRegisterRequest.firstname())
                .lastname(customerRegisterRequest.lastname())
                .email(customerRegisterRequest.email())
                .build();


               customerRepository.saveAndFlush(customer);

//        FraudResponse fraudResponse = restTemplate.getForObject("http://fraud/api/v1/fraud/{customerId}", FraudResponse.class, customer.getId());
        FraudResponse fraudResponse= fraudClient.isFraudster(customer.getId());

              if (fraudResponse.isFraudster())
              {
                  throw new IllegalStateException("isFraudster");
              }

              notificationClient.sendNotification(new NotificationRequest(
                     String.format("hi %s , welcome to ahmed",customer.getFirstname()),
                      customer.getEmail(),

                      customer.getId()


              ));

    }
}
