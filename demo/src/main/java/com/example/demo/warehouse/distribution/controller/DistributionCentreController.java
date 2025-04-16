package com.example.demo.warehouse.distribution.controller;

import com.example.demo.warehouse.distribution.model.DistributionCentre;
import com.example.demo.warehouse.distribution.model.Item;
import com.example.demo.warehouse.distribution.service.DistributionCentreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/distribution-centres")
public class DistributionCentreController {

    private final DistributionCentreService distributionCentreService;

    @Autowired
    public DistributionCentreController(DistributionCentreService distributionCentreService) {
        this.distributionCentreService = distributionCentreService;
    }

    @GetMapping
    public ResponseEntity<List<DistributionCentre>> getAllDistributionCentres() {
        return ResponseEntity.ok(distributionCentreService.getAllDistributionCentres());
    }

    @PostMapping("/{centreId}/items")
    public ResponseEntity<Item> addItemToDistributionCentre(@PathVariable Long centreId, @RequestBody Item item) {
        Item savedItem = distributionCentreService.addItemToDistributionCentre(centreId, item);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedItem);
    }

    @DeleteMapping("/items/{itemId}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long itemId) {
        distributionCentreService.deleteItem(itemId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/items")
    public ResponseEntity<List<Item>> findItemsByNameAndBrand(
            @RequestParam String name,
            @RequestParam String brand) {
        List<Item> items = distributionCentreService.findItemsByNameAndBrand(name, brand);
        return ResponseEntity.ok(items);
    }

    @PostMapping("/request")
    public ResponseEntity<Item> requestItem(
            @RequestParam String name,
            @RequestParam String brand,
            @RequestParam(defaultValue = "1") int quantity) {
        Item requestedItem = distributionCentreService.requestItem(name, brand, quantity);
        
        if (requestedItem != null) {
            return ResponseEntity.ok(requestedItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
