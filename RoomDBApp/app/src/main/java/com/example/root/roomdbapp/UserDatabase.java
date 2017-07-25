package com.example.root.roomdbapp;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by root on 20/7/17.
 */
@Database(entities = {User.class}, version = 2)
public abstract class UserDatabase extends RoomDatabase {
    public abstract UserDao userDao();

    private static UserDatabase userDatabase;

    public static UserDatabase getUserDatabase(Context context){
        if (userDatabase==null) {
            userDatabase = Room.databaseBuilder(context.getApplicationContext(),
                    UserDatabase.class, "user-database").build();
        }
        return userDatabase;
    }

}
