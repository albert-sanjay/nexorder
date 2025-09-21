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

    public ProductDto() {}

    public ProductDto(long id, String name, String description, BigDecimal price, int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
