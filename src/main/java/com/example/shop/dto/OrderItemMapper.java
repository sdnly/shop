package com.example.shop.dto;

import com.example.shop.model.OrderItem;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    OrderItemDto toDto(OrderItem source);
    OrderItem toEntity(OrderItemDto source);
    List<OrderItemDto> toDtos(List<OrderItem> source);
}
