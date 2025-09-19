package org.alphabet.nexorder.mapper;

import org.alphabet.nexorder.dto.ProductDto;
import org.alphabet.nexorder.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toDto(Product product);
    Product toEntity(ProductDto productDto);
}
