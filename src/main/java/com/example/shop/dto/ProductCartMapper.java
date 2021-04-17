package com.example.shop.dto;

import com.example.shop.model.ProductCart;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductCartMapper {

    ProductCartDto toDto(ProductCart source);
    ProductCart toEntity(ProductDto source);
    List<ProductCartDto> toDtos(List<ProductCart> source);
}
