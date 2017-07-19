package com.example.root.sqlitetestapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by root on 19/7/17.
 */
@RunWith(JUnit4.class)
public class SQLiteDBTest {
    DBHelper dbHelper;
    SQLiteDatabase sqLiteDatabase;
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void databaseCreated(){
        dbHelper = new DBHelper(mainActivityActivityTestRule.getActivity());
        sqLiteDatabase = dbHelper.getWritableDatabase();
        assertTrue(sqLiteDatabase.isOpen());
    }

    @Test
    public void databaseInsertTest(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBContract.User.COLUMN_NAME,"Kush");
        contentValues.put(DBContract.User.COLUMN_AGE,21);

        long assignId =  sqLiteDatabase.insert(DBContract.User.TABLE_NAME,null,contentValues);
        assertTrue(assignId!=-1);
    }
    @After
    public void databaseClosing(){
        sqLiteDatabase.close();
    }

}
