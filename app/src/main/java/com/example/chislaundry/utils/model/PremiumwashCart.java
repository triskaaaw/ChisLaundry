package com.example.chislaundry.utils.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "premiumwash_table")
public class PremiumwashCart {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String premiumwashName;
    private int premiumwashImage;
    private double premiumwashPrice;

    private int quantity;
    private double totalItemPrice;



    public String getPremiumwashName() {
        return premiumwashName;
    }

    public void setPremiumwashName(String premiumwashName) {
        this.premiumwashName = premiumwashName;
    }

    public int getPremiumwashImage() {
        return premiumwashImage;
    }

    public void setPremiumwashImage(int premiumwashImage) {
        this.premiumwashImage = premiumwashImage;
    }

    public double getPremiumwashPrice() {
        return premiumwashPrice;
    }

    public void setPremiumwashPrice(double premiumwashPrice) {
        this.premiumwashPrice = premiumwashPrice;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalItemPrice() {
        return totalItemPrice;
    }

    public void setTotalItemPrice(double totalItemPrice) {
        this.totalItemPrice = totalItemPrice;
    }
}