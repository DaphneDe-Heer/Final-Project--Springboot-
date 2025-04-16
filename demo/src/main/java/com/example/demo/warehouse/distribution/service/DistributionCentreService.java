package com.example.demo.warehouse.distribution.service;

import com.example.demo.warehouse.distribution.model.DistributionCentre;
import com.example.demo.warehouse.distribution.model.Item;
import com.example.demo.warehouse.distribution.repository.DistributionCentreRepository;
import com.example.demo.warehouse.distribution.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DistributionCentreService {

    private final DistributionCentreRepository distributionCentreRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public DistributionCentreService(DistributionCentreRepository distributionCentreRepository, ItemRepository itemRepository) {
        this.distributionCentreRepository = distributionCentreRepository;
        this.itemRepository = itemRepository;
    }

    public List<DistributionCentre> getAllDistributionCentres() {
        return distributionCentreRepository.findAll();
    }

    public Optional<DistributionCentre> getDistributionCentreById(Long id) {
        return distributionCentreRepository.findById(id);
    }

    @Transactional
    public Item addItemToDistributionCentre(Long centreId, Item item) {
        Optional<DistributionCentre> centreOptional = distributionCentreRepository.findById(centreId);
        if (centreOptional.isPresent()) {
            DistributionCentre centre = centreOptional.get();
            item.setDistributionCentre(centre);
            return itemRepository.save(item);
        }
        throw new IllegalArgumentException("Distribution Centre not found with ID: " + centreId);
    }

    @Transactional
    public void deleteItem(Long itemId) {
        itemRepository.deleteById(itemId);
    }

    public List<Item> findItemsByNameAndBrand(String name, String brand) {
        return itemRepository.findAvailableItemsByNameAndBrand(name, brand);
    }

    @Transactional
    public Item requestItem(String name, String brand, int quantity) {
        List<Item> availableItems = itemRepository.findAvailableItemsByNameAndBrand(name, brand);
        
        if (availableItems.isEmpty()) {
            return null;
        }
        
        
        for (Item item : availableItems) {
            if (item.getQuantity() >= quantity) {
                
                item.setQuantity(item.getQuantity() - quantity);
                itemRepository.save(item);
                
                
                Item requestedItem = new Item();
                requestedItem.setName(item.getName());
                requestedItem.setBrand(item.getBrand());
                requestedItem.setSize(item.getSize());
                requestedItem.setColor(item.getColor());
                requestedItem.setPrice(item.getPrice());
                requestedItem.setQuantity(quantity);
                
                return requestedItem;
            }
        }
        
        return null;
    }
}
