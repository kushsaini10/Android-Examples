package com.example.root.roomdbapp;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by root on 20/7/17.
 */
@Entity(tableName = "user")
public class User {
    public User(String name, String age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @PrimaryKey(autoGenerate = true)
    public int user_id;

    public String name;
    public String age;
    public String address;
}
