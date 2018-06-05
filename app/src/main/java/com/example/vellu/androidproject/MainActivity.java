package com.example.vellu.androidproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.file.ClosedDirectoryStreamException;

public class MainActivity extends AppCompatActivity {

    Button buttonOne;
    Button buttonTwo;
    EditText typeHere;
    EditText typeHereTwo;
    TextView alertText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(MainActivity.this, R.string.thisismain, Toast.LENGTH_SHORT).show();

        buttonOne = (Button) findViewById(R.id.buttonone);
        buttonTwo = (Button) findViewById(R.id.buttontwo);

        typeHere = (EditText) findViewById(R.id.editTextOne);
        typeHereTwo = (EditText) findViewById(R.id.editTextTwo);

        alertText = (TextView) findViewById(R.id.alertTextView);


        MoveToActivityTwo();
        MoveToActivityThree();

    }
    public void MoveToActivityTwo () {
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

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
                        alertText.setVisibility(View.VISIBLE);
                        Intent moveTo = new Intent(MainActivity.this, ActivityTwo.class);
                        moveTo.putExtra("com.example.vellu.androidproject.showone",typeHere.getText().toString());
                        moveTo.putExtra("com.example.vellu.androidproject.showtwo",typeHereTwo.getText().toString());
                        finish();
                        startActivity(moveTo);
                        finish();
                    }
                });
                builder.show();

            }
        });
    }
    public void MoveToActivityThree () {
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

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

                        alertText.setVisibility(View.VISIBLE);

                        Intent moveTo = new Intent(MainActivity.this, ActivityThree.class);
                        moveTo.putExtra("com.example.vellu.androidproject.showthree",typeHere.getText().toString());
                        moveTo.putExtra("com.example.vellu.androidproject.showfour",typeHereTwo.getText().toString());
                        startActivity(moveTo);
                    }
                });
                builder.show();

            }
        });
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

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

                    alertText.setVisibility(View.VISIBLE);
                    finish();
                    System.exit(0);
                }
            });
            builder.show();

        }
        return super.onKeyDown(keyCode, event);
    }
}
