package com.inventory.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InventoryEntity {
	
	public InventoryEntity() {
		  
    }
 
    public InventoryEntity(String productName, int productCount) {
        this.productName = productName;
        this.productCount = productCount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String productName;
    private int productCount;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {

        this.productName = productName;
    }

    public int getproductCount() {

        return productCount;
    }

    public void setProductCount(int productCount) {

        this.productCount = productCount;
    }

}

