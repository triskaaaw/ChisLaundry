package com.example.chislaundry;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface UserDao {
    @Insert
    void registerUser(UserEntity userEntity);

}
