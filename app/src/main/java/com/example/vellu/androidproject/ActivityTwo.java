package com.example.vellu.androidproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityTwo extends Activity {

    Button buttonback;
    Button buttonList;

    TextView textViewSix;
    TextView textViewSeven;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        Toast.makeText(ActivityTwo.this, R.string.youopenedtwo, Toast.LENGTH_SHORT).show();

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

                AlertDialog.Builder builder = new AlertDialog.Builder(ActivityTwo.this);

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

                        Intent moveTo = new Intent(ActivityTwo.this, NumberActivity.class);
                        startActivity(moveTo);
                    }
                });
                builder.show();

            }
        });
    }
    public void goList () {
        buttonList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ActivityTwo.this);

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

                        Intent moveTo = new Intent(ActivityTwo.this, ActivityList.class);
                        startActivity(moveTo);
                    }
                });
                builder.show();

            }
        });
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(ActivityTwo.this);

            builder.setCancelable(true);
            builder.setTitle(R.string.quitapp);
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
                    System.exit(0);

                }
            });
            builder.show();

        }
        return super.onKeyDown(keyCode, event);
    }
}
