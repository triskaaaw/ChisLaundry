package com.example.chislaundry.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.chislaundry.utils.model.PremiumwashCart;

import java.util.List;


@Dao
public interface CartDao {
    @Insert
    void insertCartItem(PremiumwashCart PremiumwashCart);

    @Query("SELECT * FROM premiumwash_table")
    LiveData<List<PremiumwashCart>> getAllCartItems();

    @Delete
    void deleteCartItem(PremiumwashCart PremiumwashCart);

    @Query("UPDATE premiumwash_table SET quantity=:quantity WHERE id=:id")
    void updateQuantity(int id, int quantity);

    @Query("UPDATE premiumwash_table SET totalItemPrice=:totalItemPrice WHERE id=:id")
    void updatePrice(int id, double totalItemPrice);

    @Query("DELETE FROM premiumwash_table")
    void deleteAllItems();
}
