package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class RestaurantActivity extends AppCompatActivity {
    DatabaseManager dbm;
    EditText restName,restLoc;
    Button add,addItems,home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        restName=(EditText)findViewById(R.id.editRestName);
        restLoc=(EditText)findViewById(R.id.editRestLocation);
        dbm=new DatabaseManager(this);
    }

    public void addData(View view)
    {
        Random rating=new Random();
        if(restName.getText().toString().equals("")||restLoc.getText().toString().equals(""))
        {
            Toast.makeText(this,"Please Enter All Fields",Toast.LENGTH_LONG).show();
        }
        else
            {
            boolean ins = dbm.insertRecord(restName.getText().toString(), restLoc.getText().toString(), rating.nextInt(5) + 1);
            if (ins) {
                Toast.makeText(this, "record inserted", Toast.LENGTH_LONG).show();
                restName.setText("");
                restLoc.setText("");
            }
            else
                Toast.makeText(this, "Fail", Toast.LENGTH_LONG).show();
        }
    }
    public void goHome(View view)
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}