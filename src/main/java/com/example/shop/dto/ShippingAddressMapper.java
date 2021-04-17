package com.example.shop.dto;

import com.example.shop.model.ShippingAddress;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShippingAddressMapper {

    ShippingAddressDto toDto(ShippingAddress source);
    ShippingAddress toEntity(ShippingAddressDto source);
    List<ShippingAddressDto> toDtos(List<ShippingAddress> source);
}
