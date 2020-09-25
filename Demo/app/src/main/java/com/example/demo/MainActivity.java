package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    DatabaseManager dbm;
public static String displayName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbm=new DatabaseManager(this);
    }

    public void onRestrauntClicked(View view)
    {
           Intent intent = new Intent(this, RestaurantActivity.class);
            startActivity(intent);
    }
    public void onCustomerClicked(View view)
    {
        Intent intent=new Intent(this,ShowRestaurant.class);
        startActivity(intent);

    }
}