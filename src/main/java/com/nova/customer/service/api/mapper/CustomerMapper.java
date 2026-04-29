package com.nova.customer.service.api.mapper;

import java.util.Optional;

import com.nova.customer.service.api.dto.request.CustomerCreateReq;
import com.nova.customer.service.api.dto.request.CustomerUpdateReq;
import com.nova.customer.service.api.dto.response.CustomerRes;
import com.nova.customer.service.domain.Customer;

public class CustomerMapper {

    public Customer toEntityCreate(CustomerCreateReq req) {
        if (req == null) return null;
        
        Customer c = new Customer();
        c.setFirstName(req.getFirstName());
        c.setMiddleName(req.getMiddleName());
        c.setLastName(req.getLastName());
        c.setSecondLastName(req.getSecondLastName());
        c.setEmail(req.getEmail());
        c.setPhone(req.getPhone());
        c.setAdress(req.getAdress());
      
        c.setIsActive(req.getIsActive() != null && req.getIsActive() ? 1 : 0);
        
        return c;
    }

    public CustomerRes toCustomerResponse(Customer c) {
        if (c == null) return null;

        return CustomerRes.builder()
                .id(c.getId())
                .firstName(c.getFirstName())
                .middleName(c.getMiddleName())
                .lastName(c.getLastName())
                .secondLastName(c.getSecondLastName())
                .email(c.getEmail())
                .phone(c.getPhone())
                .adress(c.getAdress())
                .createdAt(c.getCreatedAt())
                .isActive(c.getIsActive() != null && c.getIsActive() == 1)
                .build();
    }

    public void update(CustomerUpdateReq req, Customer existing) {
        if (req == null || existing == null) return;

        Optional.ofNullable(req.getFirstName()).filter(s -> !s.isBlank()).ifPresent(existing::setFirstName);
        Optional.ofNullable(req.getMiddleName()).filter(s -> !s.isBlank()).ifPresent(existing::setMiddleName);
        Optional.ofNullable(req.getLastName()).filter(s -> !s.isBlank()).ifPresent(existing::setLastName);
        Optional.ofNullable(req.getSecondLastName()).filter(s -> !s.isBlank()).ifPresent(existing::setSecondLastName);
        Optional.ofNullable(req.getEmail()).filter(s -> !s.isBlank()).ifPresent(existing::setEmail);
        Optional.ofNullable(req.getPhone()).filter(s -> !s.isBlank()).ifPresent(existing::setPhone);
        Optional.ofNullable(req.getAdress()).filter(s -> !s.isBlank()).ifPresent(existing::setAdress);
        
        Optional.ofNullable(req.getIsActive())
                .ifPresent(active -> existing.setIsActive(active ? 1 : 0));
    }
}
