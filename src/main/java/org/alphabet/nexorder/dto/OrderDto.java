package org.alphabet.nexorder.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.alphabet.nexorder.enums.OrderStatus;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDto {
    private long id;

    @NotNull(message = "User is required")
    private Long userid;

    @NotNull(message = "Date cannot be in the past")
    @FutureOrPresent
    private LocalDateTime orderDate;

    private OrderStatus status = OrderStatus.CREATED;

    @NotEmpty(message = "Order must have at least one item")
    @Valid
    private List<OrderItemDto> items;



}
