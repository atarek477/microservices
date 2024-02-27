package com.ahmed.app.controller;


import com.ahmed.app.model.FraudResponse;
import com.ahmed.app.repository.FraudRepository;
import com.ahmed.app.service.FraudService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fraud")
@AllArgsConstructor
public class FraudController {
    private final FraudService fraudService;



    @GetMapping("/{customerId}")
    public FraudResponse isFraudster (@PathVariable("customerId") Integer customerId){
        Boolean isFruadster = fraudService.isFraudCheck(customerId);
        return new FraudResponse(isFruadster);

    }



}
