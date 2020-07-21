package com.inventory.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.inventory.entity.InventoryEntity;
import com.inventory.repository.InventoryRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
class InventoryManagementApplicationTests {

	@Autowired
	private InventoryRepository inventoryRepository;

	@Test
	public void contextLoads() {

	}

	@Test
	public void testAddInventoryProduct() {
		InventoryEntity inventory = new InventoryEntity();
		inventory.setProductName("chargers");
		inventory.setProductCount(10);
		InventoryEntity inventoryEntity = inventoryRepository.save(inventory);
		assertNotNull(inventoryEntity);
	}

	@Test
	public void testGetInventoryProducts() {
		List<InventoryEntity> inventory = inventoryRepository.findAll();
		assertNotNull(inventory);
	}

	@Test
	public void testGetEmployeeById() {
		Optional<InventoryEntity> inventoryEntity = inventoryRepository.findById(1);
		System.out.println(inventoryEntity.get().getProductName());
		assertEquals("monitors", inventoryEntity.get().getProductName());
	}

	@Test
	public void testUpdateEmployee() {
		InventoryEntity inventoryEntity = new InventoryEntity();
		Optional<InventoryEntity> inventory = inventoryRepository.findById(3);
		if (inventory.isPresent()) {
			inventoryEntity = inventory.get();
		}
		inventoryEntity.setProductName("desks");
		inventoryEntity.setProductCount(16);
		InventoryEntity entity = inventoryRepository.save(inventoryEntity);
		assertNotNull(entity);
	}

	@Test
	public void testDeleteInventoryProduct() {
		if (inventoryRepository.existsById(2)) {
			inventoryRepository.deleteById(2);
		}
	}
}
