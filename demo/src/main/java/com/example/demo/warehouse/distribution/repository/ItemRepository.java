package com.example.demo.warehouse.distribution.repository;

import com.example.demo.warehouse.distribution.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByNameAndBrand(String name, String brand);
    
    @Query("SELECT i FROM Item i WHERE i.name = ?1 AND i.brand = ?2 AND i.quantity > 0")
    List<Item> findAvailableItemsByNameAndBrand(String name, String brand);
}
