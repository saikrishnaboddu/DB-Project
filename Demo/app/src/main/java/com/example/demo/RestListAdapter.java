package com.example.demo;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RestListAdapter extends ArrayAdapter {

List list=new ArrayList();
    public RestListAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(Object object) {

        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    static class LayoutHandler
    {
        TextView restName,restLocation,restRating;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row=convertView;
        LayoutHandler layoutHandler;
        if(row==null)
        {
            LayoutInflater layoutInflater=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.row_layout,parent,false);
            layoutHandler=new LayoutHandler();
            layoutHandler.restName= row.findViewById(R.id.restrauntName);
            layoutHandler.restLocation= row.findViewById(R.id.restaurantLocation);
            layoutHandler.restRating= row.findViewById(R.id.restaurantRating);
            row.setTag(layoutHandler);
        }
        else
        {
            layoutHandler=(LayoutHandler)row.getTag();
        }
        RestaurantData restaurantData=(RestaurantData)this.getItem(position);
        layoutHandler.restName.setText(restaurantData.getRestName());
        layoutHandler.restLocation.setText(restaurantData.getRestLocation());
        layoutHandler.restRating.setText(restaurantData.getRestRating());
     //   return super.getView(position, convertView, parent);
return row;
    }
}