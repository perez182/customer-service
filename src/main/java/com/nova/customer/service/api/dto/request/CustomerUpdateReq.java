package com.nova.customer.service.api.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerUpdateReq {
    @NotNull
    private Long id;

    @Size(max = 50)
    private String firstName;

    @Size(max = 50)
    private String middleName;
    
    @Size(max = 50)
    private String lastName;

    @Size(max = 50) 
    private String secondLastName;
    

    @Size(max = 50)
    private String email; 
    

    @Size(max = 20)
    private String phone;

    @Size(max = 255)
    private String address; 
    
    private Boolean isActive; 
}
