package com.inventory.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.entity.InventoryEntity;
import com.inventory.service.InventoryService;

@RestController
@RequestMapping("/api")
public class InventoryController {
	private static final Logger logger = LoggerFactory.getLogger(InventoryController.class);
	
	@Autowired
	private InventoryService inventoryService;
	
	@PostMapping("/addInventoryProduct")
	public InventoryEntity addInventoryProduct(@RequestBody	InventoryEntity inventoryEntity) {
		logger.info("Adding inventory product into inventory_entity table :: :: ::");
		return inventoryService.saveInventoryEntity(inventoryEntity);		
	}
	
	@PostMapping("/addInventoryProducts")
	public List<InventoryEntity> addInventoryProducts(@RequestBody	List<InventoryEntity> inventoryEntityproducts) {
		
		logger.info("Adding inventory products into inventory_entity table :: :: ::");
		return inventoryService.saveInventoryEntityProducts(inventoryEntityproducts);
		
	}
	
	@GetMapping("/inventoryProduct/{productId}")
	public InventoryEntity findProductById(@PathVariable Integer productId) {
		
		logger.info("Retrieving inventory product from inventory_entity table :: :: ::");
		return inventoryService.getInventoryProductById(productId);
		
	}
	
	@GetMapping("/inventoryProducts")
	public List<InventoryEntity> findInventorydProducts() {
		
		logger.info("Retrieving inventory products from inventory_entity table :: :: ::");
		return inventoryService.getInventoryProducts();
		
	}
	
	@PutMapping("/updateInventoryProduct/{productId}")
	public InventoryEntity updateInventoryProduct(@PathVariable Integer productId, @RequestBody InventoryEntity inventoryEntity) {
		
		logger.info("Updating inventory product into inventory_entity table :: :: ::");
		return inventoryService.updateInventoryEntity(productId,inventoryEntity);
		
	}
	
	@DeleteMapping("/delete/{productId}")
	public String deleteInventoryProduct(@PathVariable Integer productId) {
		
		logger.info("Deleting inventory product from inventory_entity table :: :: ::");
		return inventoryService.deleteInventoryProduct(productId);
		
	}

}
