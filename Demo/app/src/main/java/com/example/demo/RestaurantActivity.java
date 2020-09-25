package com.example.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Random;

public class RestaurantActivity extends AppCompatActivity {
    DatabaseManager dbm;
    EditText restName, restLoc;
    Button add, addItems, home;

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        bottomNavigationView = findViewById(R.id.bottomNavBar);
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavBarImpl);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new Insert()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavBarImpl =
            new BottomNavigationView.OnNavigationItemSelectedListener() {

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment fragment = null;
                    switch (menuItem.getItemId()) {
                        case R.id.insert:
                            fragment = new Insert();
                            break;

                        case R.id.update:
                            fragment = new Update();
                            break;

                        case R.id.delete:
                            fragment = new Delete();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
                    return true;
                }
            };
    public void onInsert(View view) {

    }


    public void goHome(View view)
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}