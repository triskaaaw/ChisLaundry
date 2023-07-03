package com.example.chislaundry;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {
    @Insert
    void registerUser(UserEntity userEntity);
    @Query("SELECT * FROM USERS WHERE userId=(:userId) and password=(:password)")
    UserEntity btnmasuk(String userId, String password);

}
