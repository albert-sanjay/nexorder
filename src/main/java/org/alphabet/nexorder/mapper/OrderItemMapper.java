package org.alphabet.nexorder.mapper;

import org.alphabet.nexorder.dto.OrderItemDto;
import org.alphabet.nexorder.model.OrderItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    OrderItemDto toDto(OrderItem orderItem);
    OrderItem toEntity(OrderItemDto orderItemDto);
}
