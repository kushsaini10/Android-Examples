package com.example.root.sqlitetestapp;

import android.provider.BaseColumns;

/**
 * Created by root on 19/7/17.
 */

public class DBContract {
    public static final class User implements BaseColumns{
        public static final String TABLE_NAME = "user";
        public static final String COLUMN_NAME = "user_name";
        public static final String COLUMN_AGE = "user_age";
//        public static final String COLUMN_REGISTRATION_ID = "user_registration_id";

    }
}
