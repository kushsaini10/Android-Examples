package com.example.root.sqlitetestapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by root on 19/7/17.
 */

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "user.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String USER_TABLE_CREATION = "CREATE TABLE " + DBContract.User.TABLE_NAME + "(" + DBContract.User._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                DBContract.User.COLUMN_NAME + " TEXT," +
                DBContract.User.COLUMN_AGE + " INTEGER);";
        sqLiteDatabase.execSQL(USER_TABLE_CREATION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + DBContract.User.TABLE_NAME);
    }
}
