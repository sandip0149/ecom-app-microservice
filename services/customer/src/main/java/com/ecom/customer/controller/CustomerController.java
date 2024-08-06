package com.ecom.customer.controller;

import com.ecom.customer.entity.CustomerDto;
import com.ecom.customer.service.CustomerService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<CustomerDto> getAll(){
        return customerService.getAllCustomer();
    }

    @GetMapping("/customers/{id}")
    public CustomerDto getByID(@PathVariable Integer id){
        return customerService.getCustomerById(id);
    }

    @PostMapping("/customers")
    public CustomerDto addCustomer(@RequestBody CustomerDto customerDto){
        return customerService.createCustomer(customerDto);
    }

    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable Integer id){
        customerService.deleteCustomer(id);
        return "Deleted SuccessFully";
    }

}
