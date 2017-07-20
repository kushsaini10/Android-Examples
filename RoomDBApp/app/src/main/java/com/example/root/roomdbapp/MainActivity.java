package com.example.root.roomdbapp;

import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.facebook.stetho.Stetho;

public class MainActivity extends AppCompatActivity {
    UserDatabase userDatabaseInstance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Stetho initialization
        Stetho.initializeWithDefaults(this);

        userDatabaseInstance = UserDatabase.getUserDatabase(this);
        User user = new User(2,"Lav","21","6/4");
        addUser(user);
    }

    public class DatabaseProcess extends AsyncTask<User,Void,String >{

        @Override
        protected String doInBackground(User... users) {
            if (userDatabaseInstance==null)
                return "null";
            userDatabaseInstance.userDao().addUser(users[0]);
            return "OK";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(getApplicationContext(),"Inserted",Toast.LENGTH_LONG).show();
        }
    }


    private void addUser(User user) {
        new DatabaseProcess().execute(user);
    }
}
