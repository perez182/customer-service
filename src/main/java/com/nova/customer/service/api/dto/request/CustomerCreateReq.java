package com.nova.customer.service.api.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class CustomerCreateReq {

    @NotBlank(message = "firstName is required")
    @Size(max = 50)
    private String firstName;

    @Size(max = 50)
    private String middleName;
    
    @NotBlank(message = "lastName is required")
    @Size(max = 50)
    private String lastName;

    @Size(max = 50) 
    private String secondLastName;
    
    @NotBlank(message = "Email is required")
    @Email(message = "Email format is invalid")
    @Size(max = 50)
    private String email; 
    

    @NotBlank(message = "Phone number is required")
    @Size(max = 20)
    @Pattern(regexp = "^\\d{10}$", message = "The phone number must contain exactly 10 digits")
    private String phone;

    @Size(max = 255)
    @NotBlank(message = "Adress is required")
    private String adress; 
    
    private Boolean isActive; 
}

