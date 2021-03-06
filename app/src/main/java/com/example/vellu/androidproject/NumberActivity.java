package com.example.vellu.androidproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NumberActivity extends Activity implements View.OnClickListener {

    Button zero,one,two,three,four,five,six,seven,eight,nine;
    TextView nicetext;

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("NumberActivity","Starting");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("NumberActivity", "Resuming");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("NumberActivity", "Restarting");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("NumberActivity", "Destroying");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("NumberActivity", "Stopping");
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.number_layout);
        Log.d("NumberActivity", "Creating");

        Toast.makeText(NumberActivity.this, R.string.youopnnumact, Toast.LENGTH_SHORT).show();

        zero = (Button) findViewById(R.id.buttonZero);
        one = (Button) findViewById(R.id.buttonOne);
        two = (Button) findViewById(R.id.buttonTwo);
        three = (Button) findViewById(R.id.buttonThree);
        four = (Button) findViewById(R.id.buttonFour);
        five = (Button) findViewById(R.id.buttonFive);
        six = (Button) findViewById(R.id.buttonSix);
        seven = (Button) findViewById(R.id.buttonSeven);
        eight = (Button) findViewById(R.id.buttonEight);
        nine = (Button) findViewById(R.id.buttonNine);
        nicetext = (TextView) findViewById(R.id.nicetext);

        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {

        switch(v.getId()) {

            case R.id.buttonZero:
                nicetext.setBackgroundColor(Color.rgb(255,0,0));
                break;
            case R.id.buttonOne:
                nicetext.setBackgroundColor(Color.rgb(0,255,0));
                break;
            case R.id.buttonTwo:
                nicetext.setBackgroundColor(Color.rgb(0,0,255));
                break;
            case R.id.buttonThree:
                nicetext.setBackgroundColor(Color.rgb(0,255,255));
                break;
            case R.id.buttonFour:
                nicetext.setBackgroundColor(Color.rgb(255,255,0));
                break;
            case R.id.buttonFive:
                nicetext.setBackgroundColor(Color.rgb(255,255,255));
                break;
            case R.id.buttonSix:
                nicetext.setBackgroundColor(Color.rgb(255,0,255));
                break;
            case R.id.buttonSeven:
                nicetext.setBackgroundColor(Color.rgb(255,100,0));
                break;
            case R.id.buttonEight:
                nicetext.setBackgroundColor(Color.rgb(100,255,0));
                break;
            case R.id.buttonNine:
                nicetext.setBackgroundColor(Color.rgb(0,255,100));
                break;
        }

        }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(NumberActivity.this);

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

