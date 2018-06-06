package com.example.vellu.androidproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonOne;
    Button buttonTwo;
    EditText typeHere;
    EditText typeHereTwo;
    TextView alertText;

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity","Starting");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("MainActivity", "Resuming");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity", "Restarting");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "Destroying");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "Stopping");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "Creating");

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
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        finishAffinity();
                    }
                    System.exit(0);
                    finish();
                }
            });
            builder.show();

        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int op = item.getItemId();
        switch (op) {

            case R.id.something1:
                Toast.makeText(MainActivity.this, R.string.youclicksome1, Toast.LENGTH_SHORT).show();
                Log.d("MainActivity" , "You are at switch case something 1");
                return true;
            case R.id.something2:
                Toast.makeText(MainActivity.this, R.string.youclicksome2, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.something3:
                Toast.makeText(MainActivity.this, R.string.youclicksome3, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.something4:
                Toast.makeText(MainActivity.this, R.string.youclicksome4, Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
