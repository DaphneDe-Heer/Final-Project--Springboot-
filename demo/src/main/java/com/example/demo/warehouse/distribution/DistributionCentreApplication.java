package com.example.demo.warehouse.distribution;

import com.example.demo.warehouse.distribution.model.DistributionCentre;
import com.example.demo.warehouse.distribution.model.Item;
import com.example.demo.warehouse.distribution.repository.DistributionCentreRepository;
import com.example.demo.warehouse.distribution.repository.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;

@SpringBootApplication
public class DistributionCentreApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistributionCentreApplication.class, args);
    }
    
    @Bean
    @Profile("dev")
    public CommandLineRunner loadDevData(DistributionCentreRepository distributionCentreRepository, 
                                      ItemRepository itemRepository) {
        return args -> {
            // Create distribution centers
            DistributionCentre centre1 = new DistributionCentre(null, "North Distribution Center", 51.5074, -0.1278, new ArrayList<>());
            DistributionCentre centre2 = new DistributionCentre(null, "South Distribution Center", 40.7128, -74.0060, new ArrayList<>());
            DistributionCentre centre3 = new DistributionCentre(null, "East Distribution Center", 35.6762, 139.6503, new ArrayList<>());
            DistributionCentre centre4 = new DistributionCentre(null, "West Distribution Center", 34.0522, -118.2437, new ArrayList<>());
            
            distributionCentreRepository.save(centre1);
            distributionCentreRepository.save(centre2);
            distributionCentreRepository.save(centre3);
            distributionCentreRepository.save(centre4);
            
            // Add items to centres
            Item item1 = new Item(null, "T-Shirt", "Nike", "M", "Black", 29.99, 20, centre1);
            Item item2 = new Item(null, "Jeans", "Levis", "32x32", "Blue", 59.99, 15, centre1);
            Item item3 = new Item(null, "Hoodie", "Adidas", "L", "Gray", 49.99, 10, centre2);
            Item item4 = new Item(null, "Sneakers", "Nike", "UK10", "White", 89.99, 5, centre2);
            Item item5 = new Item(null, "T-Shirt", "Adidas", "S", "Red", 24.99, 25, centre3);
            Item item6 = new Item(null, "Jacket", "North Face", "XL", "Green", 149.99, 8, centre3);
            Item item7 = new Item(null, "Socks", "Puma", "One Size", "Black", 9.99, 50, centre4);
            Item item8 = new Item(null, "Cap", "Nike", "Adjustable", "Blue", 19.99, 30, centre4);
            
            itemRepository.save(item1);
            itemRepository.save(item2);
            itemRepository.save(item3);
            itemRepository.save(item4);
            itemRepository.save(item5);
            itemRepository.save(item6);
            itemRepository.save(item7);
            itemRepository.save(item8);
        };
    }
    
    @Bean
    @Profile("qa")
    public CommandLineRunner loadQaData(DistributionCentreRepository distributionCentreRepository, 
                                      ItemRepository itemRepository) {
        return args -> {
            // Create distribution centers with different data for QA environment
            DistributionCentre centre1 = new DistributionCentre(null, "QA North Centre", 52.5074, -1.1278, new ArrayList<>());
            DistributionCentre centre2 = new DistributionCentre(null, "QA South Centre", 41.7128, -75.0060, new ArrayList<>());
            DistributionCentre centre3 = new DistributionCentre(null, "QA East Centre", 36.6762, 140.6503, new ArrayList<>());
            DistributionCentre centre4 = new DistributionCentre(null, "QA West Centre", 35.0522, -119.2437, new ArrayList<>());
            
            distributionCentreRepository.save(centre1);
            distributionCentreRepository.save(centre2);
            distributionCentreRepository.save(centre3);
            distributionCentreRepository.save(centre4);
            
            // QA test data
            Item item1 = new Item(null, "QA T-Shirt", "Nike", "M", "Black", 29.99, 20, centre1);
            Item item2 = new Item(null, "QA Jeans", "Levis", "32x32", "Blue", 59.99, 15, centre1);
            Item item3 = new Item(null, "QA Hoodie", "Adidas", "L", "Gray", 49.99, 10, centre2);
            Item item4 = new Item(null, "QA Sneakers", "Nike", "UK10", "White", 89.99, 5, centre2);
            
            itemRepository.save(item1);
            itemRepository.save(item2);
            itemRepository.save(item3);
            itemRepository.save(item4);
        };
    }
}

