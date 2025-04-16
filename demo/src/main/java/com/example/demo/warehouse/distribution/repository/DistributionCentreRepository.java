package com.example.demo.warehouse.distribution.repository;

import com.example.demo.warehouse.distribution.model.DistributionCentre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributionCentreRepository extends JpaRepository<DistributionCentre, Long> {
}
