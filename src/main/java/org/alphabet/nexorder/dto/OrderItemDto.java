package org.alphabet.nexorder.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class OrderItemDto {
    private long id;

    @NotNull(message = "Product is required")
    private long productId;

    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Order quantity cannot be less than 1")
    private int quantity;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0.0")
    @Digits(integer = 10, fraction = 2, message = "Price must be a valid monetary value")
    private BigDecimal price;

}
