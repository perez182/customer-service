package com.nova.customer.service.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nova.customer.service.api.dto.request.CustomerCreateReq;
import com.nova.customer.service.api.dto.request.CustomerUpdateReq;
import com.nova.customer.service.api.dto.response.CustomerRes;
import com.nova.customer.service.api.mapper.CustomerMapper;
import com.nova.customer.service.domain.Customer;
import com.nova.customer.service.infrastructure.repository.CustomerRepository;
import com.nova.customer.service.service.CustomerService;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CustomerServiceImp implements CustomerService {
    private final CustomerMapper mapper;
    private final CustomerRepository repository;


    @Override
    public CustomerRes create(CustomerCreateReq req) {
        Customer customer = repository.save(mapper.toEntityCreate(req));
        return mapper.toCustomerResponse(customer);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Delete failed. Customer ID " + id + " not found.");
        }
        repository.deleteById(id);
        
    }

    @Override
    public List<CustomerRes> getAll() {
        return repository.findAll().stream().map(mapper::toCustomerResponse).toList();

    }

    @Override
    public CustomerRes getCustomerByID(Long id) {
        return repository.findById(id)
        .map(mapper::toCustomerResponse)
        .orElseThrow(() -> new EntityNotFoundException("Customer not found with ID: " + id));
    }

    @Override
    public CustomerRes update(CustomerUpdateReq req) {
        Customer existing = repository.findById(req.getId())
                .orElseThrow(() -> new EntityNotFoundException("Update failed. Customer ID " + req.getId() + " not found."));
        
        mapper.update(req, existing);
        return mapper.toCustomerResponse(repository.save(existing));
    }

}
