package com.example.chislaundry.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.chislaundry.dao.CartDao;
import com.example.chislaundry.utils.model.PremiumwashCart;

@Database(entities = {PremiumwashCart.class}, version = 1)
public abstract class CartDatabase extends RoomDatabase {
    public abstract CartDao cartDao();
    private static CartDatabase instance;

    public static synchronized CartDatabase getInstance(Context context){
        if(instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext()
                           , CartDatabase.class, "PremiumwashDatabase")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
