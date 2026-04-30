package com.nova.customer.service.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nova.customer.service.domain.Customer;

public interface CustomerRepository extends JpaRepository <Customer,Long> {

}
