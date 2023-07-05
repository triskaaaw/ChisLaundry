package com.example.chislaundry.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.chislaundry.repository.CartRepo;
import com.example.chislaundry.utils.model.PremiumwashCart;

import java.util.List;

public class CartViewModel extends AndroidViewModel {

    private CartRepo cartRepo;


    public CartViewModel(@NonNull Application application) {
        super(application);
        cartRepo = new CartRepo(application);
    }

    public LiveData<List<PremiumwashCart>> getAllCartItems(){
        return cartRepo.getAllCartItemsLiveData();
    }

    public void insertCartItem(PremiumwashCart PremiumwashCart){
        cartRepo.insertCartItem(PremiumwashCart);
    }

    public void updateQuantity(int id, int quantity){
        cartRepo.updateQuantity(id , quantity);
    }

    public void updatePrice(int id, double price){
        cartRepo.updatePrice(id, price);
    }

    public void deleteCartItem(PremiumwashCart PremiumwashCart){
        cartRepo.deleteCartItem(PremiumwashCart);
    }

    public void deleteAllCartItems(){
        cartRepo.deleteAllCartItems();
    }
}
