package com.ahmed.app.service;

import com.ahmed.app.RabbitMQProducer;
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
    private final RabbitMQProducer rabbitMQProducer;


    public void registerCustomerSevice(CustomerRegisterRequest customerRegisterRequest) {
        Customer customer = Customer.builder()
                .firstname(customerRegisterRequest.firstname())
                .lastname(customerRegisterRequest.lastname())
                .email(customerRegisterRequest.email())
                .build();


        customerRepository.saveAndFlush(customer);

        FraudResponse fraudResponse = fraudClient.isFraudster(customer.getId());
        System.out.println(fraudResponse.isFraudster());
        if (fraudResponse.isFraudster()) {
            System.out.println("in");
        }
        NotificationRequest notificationRequest = new NotificationRequest(
                String.format("hi %s , welcome to ahmed", customer.getFirstname()),
                customer.getEmail(),
                customer.getId()
     );

        rabbitMQProducer.publish(notificationRequest,"internal.exchange","internal.notification.routing.keys");

    }
}
