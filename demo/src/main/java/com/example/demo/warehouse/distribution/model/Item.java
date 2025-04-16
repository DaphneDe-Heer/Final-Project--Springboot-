package com.example.demo.warehouse.distribution.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String brand;
    private String size;
    private String color;
    private Double price;
    private Integer quantity;
    
    @ManyToOne
    @JoinColumn(name = "distribution_centre_id")
    private DistributionCentre distributionCentre;
}
