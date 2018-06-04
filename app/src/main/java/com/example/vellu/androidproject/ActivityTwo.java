package com.example.vellu.androidproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class ActivityTwo extends Activity {

    Button buttonback;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        buttonback = (Button) findViewById(R.id.buttonback);
        returnMenu ();
    }
    public void returnMenu () {
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveTo = new Intent(ActivityTwo.this, MainActivity.class);
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