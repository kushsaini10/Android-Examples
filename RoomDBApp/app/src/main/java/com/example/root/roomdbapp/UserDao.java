package com.example.root.roomdbapp;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by root on 20/7/17.
 */
@Dao
public interface UserDao {
    @Insert
    public void addUser(User user);

    @Query("SELECT * FROM user")
    public List<User> getAllUsers();
}
