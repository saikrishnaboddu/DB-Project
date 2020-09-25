package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

public class ShowRestaurant extends AppCompatActivity {
    ListView listView;
    Cursor cursor;
    SQLiteDatabase sqLiteDatabase;
    DatabaseManager dbm;
    RestListAdapter restListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_restaurant);
        listView=(ListView) findViewById(R.id.list_view);
        dbm=new DatabaseManager(this);
        sqLiteDatabase=dbm.getReadableDatabase();
        cursor=dbm.displayTable();
        restListAdapter=new RestListAdapter(getApplicationContext(),R.layout.row_layout);
        listView.setAdapter(restListAdapter);
        if(cursor.moveToFirst())
        {

            do{
                String restaurant_Name,restaurant_Location,restaurant_Rating;
                restaurant_Name=cursor.getString(1);
                restaurant_Location=cursor.getString(2);
                restaurant_Rating=cursor.getString(3);
                RestaurantData restaurantData=new RestaurantData(restaurant_Name,restaurant_Location,restaurant_Rating);
                restListAdapter.add(restaurantData);



            }while (cursor.moveToNext());
        }
    }
}