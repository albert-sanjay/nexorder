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

    public OrderDto() {}

    public OrderDto(long id, Long userid, LocalDateTime orderDate, OrderStatus status, List<OrderItemDto> items) {
        this.id = id;
        this.userid = userid;
        this.orderDate = orderDate;
        this.status = status;
        this.items = items;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItemDto> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDto> items) {
        this.items = items;
    }
}
