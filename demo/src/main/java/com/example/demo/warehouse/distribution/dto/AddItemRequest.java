package com.example.demo.warehouse.distribution.dto;
import lombok.Data;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
@Data

public class AddItemRequest {
    @NotNull(message = "Item ID cannot be null")
    private Long itemId;
    
    @Min(value = 1, message = "Quantity must be at least 1")
    private int quantity;
    
}
