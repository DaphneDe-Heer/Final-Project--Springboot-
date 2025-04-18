package com.example.demo.warehouse.distribution.dto;

import lombok.Data;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Data
public class RequestItemDto {
    @NotBlank(message = "Brand cannot be blank")
    private String brand;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Min(value = 1, message = "Quantity to request must be at least 1")
    private int quantity = 1; 
}
