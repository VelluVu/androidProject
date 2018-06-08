package com.example.vellu.androidproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseHelper extends SQLiteOpenHelper{

    public static final Integer DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "users_db";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(User.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(User.DROP_TABLE);

        onCreate(db);

    }

    public long insertUser(String name, String surname,
                              String address, String city, String country) {

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(User.USERS_COLUMN_NAME, name);
            contentValues.put(User.USERS_COLUMN_SURNAME, surname);
            contentValues.put(User.USERS_COLUMN_ADDRESS, address);
            contentValues.put(User.USERS_COLUMN_CITY, city);
            contentValues.put(User.USERS_COLUMN_COUNTRY, country);
            long id = db.insert(User.CREATE_TABLE,null,contentValues);
            db.close();
            return id;
            //IF KNOW SQL SENTENCES USE THIS
            //db.execSQL("INSERT INTO user (name, surname, address, city, country) VALUES (" + name + ", " + surname + ", " + address + ", " + city + ", " + country + ")");


            //ALTERNATIVE

            /*ContentValues newRecord = new ContentValues();
            newRecord.put("id",id);
            newRecord.put("name", name);

            db.insert("user", null, newRecord);*/

    }

    public User getUser(long id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(User.USERS_TABLE_NAME,
                new String[]{User.USERS_COLUMN_ID, User.USERS_COLUMN_NAME,
                        User.USERS_COLUMN_SURNAME, User.USERS_COLUMN_ADDRESS,
                        User.USERS_COLUMN_CITY, User.USERS_COLUMN_COUNTRY},
                User.USERS_COLUMN_ID + "= ?", new String[]{String.valueOf(id)},
                null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

            User user = new User(
                    cursor.getInt(cursor.getColumnIndex(User.USERS_COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndex(User.USERS_COLUMN_NAME)),
                    cursor.getString(cursor.getColumnIndex(User.USERS_COLUMN_SURNAME)),
                    cursor.getString(cursor.getColumnIndex(User.USERS_COLUMN_ADDRESS)),
                    cursor.getString(cursor.getColumnIndex(User.USERS_COLUMN_CITY)),
                    cursor.getString(cursor.getColumnIndex(User.USERS_COLUMN_COUNTRY)));

            cursor.close();

            return user;

    }
    public Integer deleteUser (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("users", "id = ?",
                new String[] {Integer.toString(id)});
    }
    public ArrayList<String> getAllUsers() {
        ArrayList<String> arrayList = new ArrayList<String>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users", null);
        cursor.moveToFirst();

        while(cursor.isAfterLast() == false) {
            arrayList.add(cursor.getString(cursor.getColumnIndex(User.USERS_COLUMN_NAME)));
            cursor.moveToNext();
        }
        return arrayList;
    }

}
