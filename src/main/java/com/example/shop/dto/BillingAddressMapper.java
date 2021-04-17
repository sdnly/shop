package com.example.shop.dto;

import com.example.shop.model.BillingAddress;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BillingAddressMapper {

    BillingAddressDto toDto(BillingAddress source);
    BillingAddress toEntity(BillingAddressDto source);
    List<BillingAddressDto> toDtos(List<BillingAddress> source);
}
