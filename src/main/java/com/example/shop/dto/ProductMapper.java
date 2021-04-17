package com.example.shop.dto;

import com.example.shop.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto toDto(Product source);
    Product toEntity(ProductDto source);
    List<ProductDto> toDtos(List<Product> source);
}
