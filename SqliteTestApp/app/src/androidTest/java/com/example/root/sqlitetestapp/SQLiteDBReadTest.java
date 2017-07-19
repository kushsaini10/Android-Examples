package com.example.root.sqlitetestapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.test.rule.ActivityTestRule;
import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.Assert.assertEquals;

/**
 * Created by root on 19/7/17.
 */
@RunWith(JUnit4.class)
public class SQLiteDBReadTest {
    DBHelper dbHelper;
    SQLiteDatabase sqLiteDatabase;

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void openDB(){
        dbHelper = new DBHelper(mainActivityActivityTestRule.getActivity());
        sqLiteDatabase = dbHelper.getReadableDatabase();
    }
    @Test
    public void getDataTest(){
        String[] columns = {DBContract.User._ID, DBContract.User.COLUMN_NAME, DBContract.User.COLUMN_AGE};
        Cursor cursor = sqLiteDatabase.query(DBContract.User.TABLE_NAME,columns,null,null,null,null,null);
        while(cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex(DBContract.User.COLUMN_NAME));
            int id = cursor.getInt(cursor.getColumnIndex(DBContract.User._ID));
            int age = cursor.getInt(cursor.getColumnIndex(DBContract.User.COLUMN_AGE));
            assertEquals("Kush",name);
            Log.d("Name",""+name);
            Log.d("Id",""+id);
            Log.d("Age",""+age);
        }
    }

    @After
    public void close(){
        sqLiteDatabase.close();
    }
}
