package com.ahmed.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.antlr.v4.runtime.misc.NotNull;

public record CustomerRegisterRequest(


        @NotBlank(message = "firstname not found")
         String firstname,
        @NotBlank(message = "lastname not found")
        String lastname,
         @Email(message = "email not valid ")
         @NotBlank(message = "email not found")
         String email

) {
}
