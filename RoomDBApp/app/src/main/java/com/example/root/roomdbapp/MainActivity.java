package com.example.root.roomdbapp;

import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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
        Button button = (Button) findViewById(R.id.btn);
        final TextView name = (TextView) findViewById(R.id.name);
        final TextView age = (TextView) findViewById(R.id.age);
        final TextView address = (TextView) findViewById(R.id.address);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user;
                user = new User(name.getText().toString(),age.getText().toString(),address.getText().toString());
                addUser(user);
            }
        });
//        User user = new User(2,"Lav","21","6/4");
//
    }

    public class DatabaseProcess extends AsyncTask<User,Void,String >{

        @Override
        protected String doInBackground(User... users) {
            if (userDatabaseInstance==null)
                return "null";
            try{
                userDatabaseInstance.userDao().addUser(users[0]);
            }catch (Exception e){
                System.out.println(e);
                return "Not Inserted";
            }
            return "Inserted";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
//            if (s=="NOT OK"){
//                s = "Enter another id";
//            }
            Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
        }
    }


    private void addUser(User user) {
        new DatabaseProcess().execute(user);
    }
}
