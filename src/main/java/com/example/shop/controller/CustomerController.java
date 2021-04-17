package com.example.shop.controller;

import com.example.shop.dto.CustomerDto;
import com.example.shop.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public List<CustomerDto> getAllCustomers() {
         return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerDto getSingleCustomer(@PathVariable long id) {
        return customerService.getSingleCustomer(id);
    }

    @PostMapping
    public CustomerDto addCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.addCustomer(customerDto);
    }

    @PutMapping
    public CustomerDto editCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.editCustomer(customerDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable long id) {
        customerService.deleteCustomer(id);
    }
}
