package com.example.demo.warehouse.distribution.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplenishSourceDto {
    private Long distributionCentreId;
    private String distributionCentreName;
    private String itemName;
    private String itemBrand;
    private int quantityDeducted;
}
