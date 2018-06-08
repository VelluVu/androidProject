package com.example.vellu.androidproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class ActivityInputData extends Activity {

    TextView name,surName,address,city,country;
    EditText editName,editSurname,editAddress,editCity,editCountry, editId;
    Button buttonAdd, buttonDelete, buttonShow;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputdata);

        name = (TextView) findViewById(R.id.textViewName);
        surName = (TextView) findViewById(R.id.textViewSurName);
        address = (TextView) findViewById(R.id.textViewAddress);
        city = (TextView) findViewById(R.id.textViewCity);
        country = (TextView) findViewById(R.id.textViewCountry);

        editName = (EditText) findViewById(R.id.editTextName);
        editSurname = (EditText) findViewById(R.id.editTextSurName);
        editAddress = (EditText) findViewById(R.id.editTextAddress);
        editCity = (EditText) findViewById(R.id.editTextCity);
        editCountry = (EditText) findViewById(R.id.editTextCountry);
        editId = (EditText) findViewById(R.id.editTextId);

        buttonAdd = (Button) findViewById(R.id.addbutton);
        buttonDelete = (Button) findViewById(R.id.deletebutton);
        buttonShow = (Button) findViewById(R.id.showbutton);

        //Using database
        myDb = new DatabaseHelper(ActivityInputData.this);

        addData();
        deleteData();
        showData();
        //using database methods
        /*if (db != null) {
            myDb.insertUsers(db);
            db.close();
        }

        db = myDb.getReadableDatabase();

        Cursor c = myDb.getUser(db, "user5");

        if (c.moveToFirst()) {
            do {
                //get column of id index 0 of String[]
                String id = c.getString(0);
                // alternate way : c.getString(c.getColumnIndex("id"));

                //get column of name index 1 of String[]
                String name = c.getString(1);
                // alternate way : c.getString(c.getColumnIndex("name"));

                Log.d("ActivityInputData.this", "RESULT: " + id + " - " + "name");

            } while(c.moveToNext());
        }*/

    }
    public void addData () {

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void deleteData() {

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void showData() {

        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(ActivityInputData.this);

            builder.setCancelable(true);
            builder.setTitle(R.string.activitychange);
            builder.setMessage(R.string.areyousure);
            builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    finish();
                }
            });
            builder.show();

        }
        return super.onKeyDown(keyCode, event);
    }
}
