package com.example.shop.dto;

import com.example.shop.model.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDto toDto(Customer source);
    Customer toEntity(CustomerDto source);
    List<CustomerDto> toDtos(List<Customer> source);
}
