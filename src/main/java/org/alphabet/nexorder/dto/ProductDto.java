package org.alphabet.nexorder.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class ProductDto {
    private long id;

    @NotBlank(message = "product name can not be empty")
    private String name;

    @NotBlank(message = "product description cannot be empty")
    private String description;

    @NotNull(message = "price cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "price must be greater than 0.0")
    @Digits(fraction = 2, integer = 10, message = "price must be a valid monetary value")
    private BigDecimal price;

    @Min(value = 0, message = "quantity cannot be less than 0")
    @NotNull(message = "quantity cannot be null")
    private int quantity;
}
