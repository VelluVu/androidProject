package com.example.vellu.androidproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityFour extends Activity {


    Button buttonFour;
    TextView textViewSpam;
    TextView textViewSpamSpam;

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ActivityFour","Starting");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("ActivityFour", "Resuming");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ActivityFour", "Restarting");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ActivityFour", "Destroying");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ActivityFour", "Stopping");
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        Log.d("ActivityFour", "Creating");

        Toast.makeText(ActivityFour.this, R.string.youopnactfour, Toast.LENGTH_SHORT).show();

        textViewSpam = (TextView) findViewById(R.id.textViewInputOneFrom);
        textViewSpamSpam = (TextView) findViewById(R.id.textViewInputTwoFrom);

        textViewSpam.setText(getIntent().getStringExtra("com.example.vellu.androidproject.showFive"));
        textViewSpamSpam.setText(getIntent().getStringExtra("com.example.vellu.androidproject.showSix"));

        buttonFour = (Button) findViewById(R.id.buttonFour);
        goToMenu();
    }

    public void goToMenu () {
        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ActivityFour.this);

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

                        Intent moveTo = new Intent(ActivityFour.this, MainActivity.class);
                        startActivity(moveTo);
                        finish();
                    }
                });
                builder.show();

            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(ActivityFour.this);

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
                    finish();
                }
            });
            builder.show();

        }
        return super.onKeyDown(keyCode, event);
    }
}
