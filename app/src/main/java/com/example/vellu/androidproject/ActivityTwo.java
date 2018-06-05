package com.example.vellu.androidproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

public class ActivityTwo extends Activity {

    Button buttonback;

    TextView textViewSix;
    TextView textViewSeven;

    String textFirst;
    String textSecond;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        textViewSix = (TextView) findViewById(R.id.textView6);
        textViewSeven = (TextView) findViewById(R.id.textView7);

        textViewSix.setText(getIntent().getStringExtra("com.example.vellu.androidproject.showone"));
        textViewSeven.setText(getIntent().getStringExtra("com.example.vellu.androidproject.showtwo"));

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
            System.exit(0);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
