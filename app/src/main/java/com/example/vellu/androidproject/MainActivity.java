package com.example.vellu.androidproject;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonOne;
    Button buttonTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonOne = (Button) findViewById(R.id.buttonone);
        buttonTwo = (Button) findViewById(R.id.buttontwo);

        MoveToActivityTwo();
        MoveToActivityThree();

    }
    public void MoveToActivityTwo () {
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveTo = new Intent(MainActivity.this, ActivityTwo.class);
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
                startActivity(moveTo);
                finish();
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
