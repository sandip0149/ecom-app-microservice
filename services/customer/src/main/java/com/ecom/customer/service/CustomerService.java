package com.ecom.customer.service;

import com.ecom.customer.entity.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto createCustomer(CustomerDto customer_data);
    CustomerDto updateCustomer(CustomerDto customer ,Integer Id);
    CustomerDto getCustomerById (Integer Id);
    List<CustomerDto> getAllCustomer();
    void deleteCustomer(Integer Id);
}
