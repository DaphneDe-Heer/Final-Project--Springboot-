package com.example.demo.warehouse.distribution.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DistributionCentre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private Double latitude;
    private Double longitude;
    
    @OneToMany(mappedBy = "distributionCentre", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Item> availableItems;
}
