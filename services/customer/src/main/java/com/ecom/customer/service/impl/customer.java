package com.ecom.customer.service.impl;

import com.ecom.customer.entity.Customer;
import com.ecom.customer.entity.CustomerDto;
import com.ecom.customer.repo.CustomerRepo;
import com.ecom.customer.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class customer implements CustomerService {

    @Autowired
    private CustomerRepo customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CustomerDto createCustomer(CustomerDto customerData) {
        Customer customer = modelMapper.map(customerData, Customer.class);
        Customer savedCustomer = customerRepository.save(customer);
        return modelMapper.map(savedCustomer, CustomerDto.class);
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerData, Integer id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setName(customerData.getName());
            customer.setEmail(customerData.getEmail());
            customer.setAddress(customerData.getAddress());
            Customer updatedCustomer = customerRepository.save(customer);
            return modelMapper.map(updatedCustomer, CustomerDto.class);
        } else {
            // Handle the case where the customer does not exist
            return null; // Or throw an exception
        }
    }

    @Override
    public CustomerDto getCustomerById(Integer id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            return modelMapper.map(optionalCustomer.get(), CustomerDto.class);
        } else {
            // Handle the case where the customer does not exist
            return null; // Or throw an exception
        }
    }

    @Override
    public List<CustomerDto> getAllCustomer() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(customer -> modelMapper.map(customer, CustomerDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }
}
