package com.example.vellu.androidproject;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.nio.file.ClosedDirectoryStreamException;

public class MainActivity extends AppCompatActivity {

    Button buttonOne;
    Button buttonTwo;
    EditText typeHere;
    EditText typeHereTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonOne = (Button) findViewById(R.id.buttonone);
        buttonTwo = (Button) findViewById(R.id.buttontwo);

        typeHere = (EditText) findViewById(R.id.editTextOne);
        typeHereTwo = (EditText) findViewById(R.id.editTextTwo);


        MoveToActivityTwo();
        MoveToActivityThree();

    }
    public void MoveToActivityTwo () {
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveTo = new Intent(MainActivity.this, ActivityTwo.class);
                moveTo.putExtra("com.example.vellu.androidproject.showone",typeHere.getText().toString());
                moveTo.putExtra("com.example.vellu.androidproject.showtwo",typeHereTwo.getText().toString());
                finish();
                startActivity(moveTo);
                finish();
            }
        });
    }
    public void MoveToActivityThree () {
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent moveTo = new Intent(MainActivity.this, ActivityThree.class);
                moveTo.putExtra("com.example.vellu.androidproject.showthree",typeHere.getText().toString());
                moveTo.putExtra("com.example.vellu.androidproject.showfour",typeHereTwo.getText().toString());
                startActivity(moveTo);
            }
        });
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            finish();
            System.exit(0);
        }
        return super.onKeyDown(keyCode, event);
    }
}
