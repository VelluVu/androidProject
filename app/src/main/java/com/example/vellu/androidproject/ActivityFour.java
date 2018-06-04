package com.example.vellu.androidproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class ActivityFour extends Activity {


    Button buttonFour;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);

        buttonFour = (Button) findViewById(R.id.buttonFour);
        goToMenu();
    }

    public void goToMenu () {
        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveTo = new Intent(ActivityFour.this, MainActivity.class);
                startActivity(moveTo);
                finish();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            finish();
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
