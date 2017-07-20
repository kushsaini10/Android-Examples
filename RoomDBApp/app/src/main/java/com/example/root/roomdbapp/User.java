package com.example.root.roomdbapp;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by root on 20/7/17.
 */
@Entity(tableName = "user")
public class User {
    public User(int user_id, String name, String age, String address) {
        this.user_id = user_id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @PrimaryKey
    public int user_id;

    public String name;
    public String age;
    public String address;
}
