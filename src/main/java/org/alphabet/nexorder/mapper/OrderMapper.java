package org.alphabet.nexorder.mapper;

import org.alphabet.nexorder.dto.OrderDto;
import org.alphabet.nexorder.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto toDto(Order order);
    Order toEntity(OrderDto orderDto);
}
