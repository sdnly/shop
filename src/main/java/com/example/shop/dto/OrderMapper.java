package com.example.shop.dto;

import com.example.shop.model.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDto toDto(Order source);
    Order toEntity(OrderDto source);
    List<OrderDto> toDtos(List<Order> source);
}
