package com.example.vellu.androidproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends Activity {

    Button buttonback;
    Button buttonList;

    TextView textViewSix;
    TextView textViewSeven;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        textViewSix = (TextView) findViewById(R.id.textView6);
        textViewSeven = (TextView) findViewById(R.id.textView7);

        textViewSix.setText(getIntent().getStringExtra("com.example.vellu.androidproject.showone"));
        textViewSeven.setText(getIntent().getStringExtra("com.example.vellu.androidproject.showtwo"));

        buttonback = (Button) findViewById(R.id.buttonback);
        buttonList = (Button) findViewById(R.id.buttonGoList);

        goList();
        goCalculator();
    }
    public void goCalculator () {
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveTo = new Intent(ActivityTwo.this, NumberActivity.class);
                startActivity(moveTo);
                finish();
            }
        });
    }
    public void goList () {
        buttonList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveTo = new Intent(ActivityTwo.this, ActivityList.class);
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
