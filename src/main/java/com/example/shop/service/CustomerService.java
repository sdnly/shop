package com.example.shop.service;

import com.example.shop.dto.CustomerDto;
import com.example.shop.dto.CustomerMapper;
import com.example.shop.model.Customer;
import com.example.shop.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerDto addCustomer(CustomerDto customerDto) {
        Customer savedCustomer = customerRepository.save(customerMapper.toEntity(customerDto));

        return customerMapper.toDto(savedCustomer);
    }

    public List<CustomerDto> getAllCustomers() {
        List<Customer> all = customerRepository.findAll();

        return customerMapper.toDtos(all);
    }

    public CustomerDto getSingleCustomer(long id) {
        Customer customer = customerRepository.findById(id).orElseThrow();

        return customerMapper.toDto(customer);
    }

    @Transactional
    public CustomerDto editCustomer(CustomerDto customerDto) {
        Customer customer = customerRepository.findById(customerDto.getId()).orElseThrow();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());

        return customerMapper.toDto(customer);
    }

    public void deleteCustomer(long id) {
        customerRepository.deleteById(id);
    }
}
