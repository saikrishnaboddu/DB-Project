package com.example.demo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Debug;

import androidx.annotation.Nullable;

public class DatabaseManager extends SQLiteOpenHelper
{
    public static final String DB_Name="Foodora.db";
    public static  final  String table_Name="Restaurant";
    public static final String Rest_ID="Rest_ID";
    public static final String Rest_Name="Rest_Name";
    public static final String Rest_Location="Rest_Location";
    public static final String Rest_Rating="Rest_Rating";

    public static final String items_table="Items";
    public static  final String item_ID="Item_ID";
    public static  final String item_Name="Item_Name";
    public static  final String item_Price="Item_Price";
    public static  final String item_Rating="Item_Rating";



    public DatabaseManager(@Nullable Context context) {
        super(context,DB_Name,null,2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+table_Name+" (Rest_ID INTEGER PRIMARY KEY AUTOINCREMENT,Rest_Name TEXT,Rest_Location TEXT,Rest_Rating INTEGER)");
        //sqLiteDatabase.execSQL("create table "+items_table+" (Item_ID INTEGER PRIMARY KEY AUTOINCREMENT,Item_Name TEXT,Item_Price INTEGER,Item_Rating INTEGER)");



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+table_Name);
        onCreate(sqLiteDatabase);
    }
    public boolean insertRecord(String restName,String restLoc,int rating,int restID)
    {
        long result=0;
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Rest_Name,restName);
        contentValues.put(Rest_Location,restLoc);
        contentValues.put(Rest_Rating,rating);
        if(restID==0)
        {
             result=db.insert(table_Name,null,contentValues);
        }
        else if(restName.equals("")&&restLoc.equals(""))
        {
            contentValues.put(Rest_ID,restID);
                db.delete(table_Name, "Rest_ID=?", new String[]{String.valueOf(restID)});

        }
        else
        {
            contentValues.put(Rest_ID,restID);

            result=db.update(table_Name,contentValues, "Rest_ID=?",new String[] {String.valueOf(restID)});
            System.out.println(contentValues);


        }
        if(result==-1)
            return  false;
        else
            return  true;
    }


    public Cursor displayTable()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor data=db.rawQuery("select * from "+table_Name,null);
        return data;
    }
}
