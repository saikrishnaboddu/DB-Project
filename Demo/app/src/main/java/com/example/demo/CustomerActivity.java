package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CustomerActivity extends AppCompatActivity {
    DatabaseManager dbm;
    RecyclerView recyclerView;
    private ListView listView;
    ArrayList<String> rest_id,rest_name,rest_location,rest_rating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        dbm=new DatabaseManager(this);
        listView=findViewById(R.id.listView);
        /*rest_id=new ArrayList<>();
        rest_name=new ArrayList<>();
        rest_location=new ArrayList<>();
        rest_rating=new ArrayList<>();*/
        ShowRestaurantData();

    }

    private void ShowRestaurantData() {
        Cursor data=dbm.displayTable();
        ArrayList<String> restData=new ArrayList<>();
        while (data.moveToNext())
        {
            restData.add("Restaurant-Name : "+data.getString(1)+"| Location : "+data.getString(2)+"| Rating : "+data.getString(3));
            /*rest_id.add(data.getString(0));
            rest_name.add(data.getString(1));
            rest_location.add(data.getString(2));
            rest_rating.add(data.getString(3));*/

        }
        ListAdapter la=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,restData);
        listView.setAdapter(la);
    }
}