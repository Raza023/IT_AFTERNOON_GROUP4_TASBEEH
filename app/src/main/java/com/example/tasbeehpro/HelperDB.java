package com.example.tasbeehpro;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteTransactionListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class HelperDB extends SQLiteOpenHelper {

    public HelperDB(@Nullable Context context) {
        super(context, "TasbeehDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE tasbeeh (id INTEGER PRIMARY KEY AUTOINCREMENT, tasbeehName VARCHAR , isRecited VARCHAR, noOfCount int)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insert(Tasbeeh tasbeeh)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "INSERT INTO tasbeeh (tasbeehName, isRecited, noOfCount) values ('"+tasbeeh.getTasbeehName()+"','"+tasbeeh.getIsRecited()+"','"+tasbeeh.getNoOfCount()+"')";
        db.execSQL(query);
    }

    public ArrayList<Tasbeeh> getTasbeeh()
    {
        ArrayList<Tasbeeh> list = new ArrayList<Tasbeeh>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT tasbeehName, isRecited, noOfCount from tasbeeh";
        Cursor cursor = db.rawQuery(query,null);


        if(cursor.moveToFirst())  //By the way no need of this.(cursor is already on  start).
        {
            while (cursor.moveToNext()) {
                list.add(new Tasbeeh(cursor.getString(0), cursor.getString(1), cursor.getInt(2)));
            }
        }
        return list;
    }

    public void delete(String str)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM tasbeeh where tasbeehName = '"+str+"'";
        db.execSQL(query);
    }

}