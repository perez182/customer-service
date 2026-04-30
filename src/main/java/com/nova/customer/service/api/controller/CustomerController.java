package com.nova.customer.service.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nova.customer.service.api.dto.request.CustomerCreateReq;
import com.nova.customer.service.api.dto.request.CustomerUpdateReq;
import com.nova.customer.service.api.dto.response.CustomerRes;
import com.nova.customer.service.service.CustomerService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("customers")
@Validated
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerRes> create(@Valid @RequestBody CustomerCreateReq req) {
        CustomerRes response = customerService.create(req);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CustomerRes>> getAll() {
        List<CustomerRes> customers = customerService.getAll();

        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerRes> getById(@PathVariable Long id) {
        CustomerRes customer = customerService.getCustomerByID(id);

        return ResponseEntity.ok(customer);
    }

    @PutMapping
    @Operation(summary = "Update customer: only fields with values will be updated. If a field is null or blank, it will not be updated.")
    public ResponseEntity<CustomerRes> update(@Valid @RequestBody CustomerUpdateReq req) {
        CustomerRes response = customerService.update(req);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        customerService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
