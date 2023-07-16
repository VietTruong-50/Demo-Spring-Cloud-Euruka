package com.example.inventoryservice;

import com.example.inventoryservice.model.Inventory;
import com.example.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return args -> {
//			Inventory inventory = new Inventory();
//			inventory.setId(UUID.randomUUID().toString());
//			inventory.setSkuCode("iphone 13");
//			inventory.setQuantity(100);
//
//			Inventory inventory1 = new Inventory();
//			inventory1.setId(UUID.randomUUID().toString());
//			inventory1.setSkuCode("iphone 14");
//			inventory1.setQuantity(100);
//
//			inventoryRepository.save(inventory);
//			inventoryRepository.save(inventory1);
		};
	}
}
