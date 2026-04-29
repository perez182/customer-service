package com.nova.customer.service.service;

import java.util.List;

import com.nova.customer.service.api.dto.response.CustomerRes;
import com.nova.customer.service.api.dto.request.CustomerCreateReq;
import com.nova.customer.service.api.dto.request.CustomerUpdateReq;

public interface CustomerService {
     List<CustomerRes> getAll();
     CustomerRes getCustomerByID(Long id);

     CustomerRes create(CustomerCreateReq req);

     CustomerRes update(CustomerUpdateReq req);

     void delete(Long id);


}
