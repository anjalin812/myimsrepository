package com.inventory.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.controller.InventoryController;
import com.inventory.entity.InventoryEntity;
import com.inventory.repository.InventoryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryService {
	
	private static final Logger logger = LoggerFactory.getLogger(InventoryService.class);

	@Autowired
	private InventoryRepository inventoryRepository;

	public InventoryEntity saveInventoryEntity(InventoryEntity inventoryEntity) {
		
		logger.info("Service class calling to store inventory product into database ....");
		return inventoryRepository.save(inventoryEntity);    	
	}

	public List<InventoryEntity> saveInventoryEntityProducts(List<InventoryEntity> inventoryProductsList) {
		
		logger.info("Service class calling to store inventory products into database ....");
		return inventoryRepository.saveAll(inventoryProductsList);    	
	}
	
	public List<InventoryEntity> getInventoryProducts() {
		
		logger.info("Service class calling to retrieve inventory products from database ....");
		return inventoryRepository.findAll();    	
	}
	
	public InventoryEntity getInventoryProductById(int productId) {
		
		logger.info("Service class calling to retrieve inventory product from database ....");
		return inventoryRepository.findById(productId).orElse(null);    	
	}	
		
	public String deleteInventoryProduct (int prodcustId) {
		
		logger.info("Service class calling to delete inventory product from database ....");
		inventoryRepository.deleteById(prodcustId);
		
		return "Invetnory prodcut is removed" + prodcustId;
		
	}
	
	public InventoryEntity updateInventoryEntity(int productId,InventoryEntity inventoryEntity) {
		
		logger.info("Service class calling to update inventory product into database ....");
		InventoryEntity existingInvProduct = inventoryRepository.findById(productId).orElse(null);
		
		existingInvProduct.setProductName(inventoryEntity.getProductName());
		existingInvProduct.setProductCount(inventoryEntity.getproductCount());
		
		return inventoryRepository.save(existingInvProduct);
		
		
	}
}
