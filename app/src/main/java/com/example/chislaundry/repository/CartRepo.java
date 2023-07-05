package com.example.chislaundry.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.chislaundry.dao.CartDao;
import com.example.chislaundry.database.CartDatabase;
import com.example.chislaundry.utils.model.PremiumwashCart;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CartRepo {
    private CartDao cartDao;
    private LiveData<List<PremiumwashCart>> allCartItemsLiveData;
    private Executor executor = Executors.newSingleThreadExecutor();

    public LiveData<List<PremiumwashCart>> getAllCartItemsLiveData() {
        return allCartItemsLiveData;
    }

    public CartRepo(Application application){
        cartDao= CartDatabase.getInstance(application).cartDao();
        allCartItemsLiveData = cartDao.getAllCartItems();
    }
    public void insertCartItem(PremiumwashCart PremiumwashCart){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cartDao.insertCartItem(PremiumwashCart);
            }
        });
    }
    public void deleteCartItem(PremiumwashCart PremiumwashCart){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cartDao.deleteCartItem(PremiumwashCart);
            }
        });
    }
    public void updateQuantity(int id, int quantity){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cartDao.updateQuantity(id, quantity);
            }
        });
    }
    public void updatePrice(int id, double price){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cartDao.updatePrice(id, price);
            }
        });
    }
    public void deleteAllCartItems(){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cartDao.deleteAllItems();
            }
        });
    }
}
