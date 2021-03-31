package com.example.kira;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SQLiteHelper extends SQLiteOpenHelper {

    public SQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table records ("+
                " id integer primary key autoincrement,"+
                " record integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }

    public void insert(int score){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("record", score);
        db.insert("records", null, values);
    }
    public ArrayList<Integer> readRecords(){
        ArrayList<Integer> records = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query="select record from records order by record desc";
        Cursor result = db.rawQuery(query, null);
        if(result.moveToFirst()){
            do{
                records.add(result.getInt(result.getColumnIndex("record")));
            }while(result.moveToNext());
        }
        return records;
    }
}
