package com.example.vellu.androidproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class ActivityThree extends Activity{

    Button buttonThree;
    ImageView imageView;
    TextView textViewFour;
    TextView textViewFive;
    String inputOne;
    String inputTwo;

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ActivityThree","Starting");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("ActivityThree", "Resuming");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ActivityThree", "Restarting");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ActivityThree", "Destroying");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ActivityThree", "Stopping");
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        Log.d("ActivityThree", "Creating");

        Toast.makeText(ActivityThree.this, R.string.youopnactthree, Toast.LENGTH_SHORT).show();

        buttonThree = (Button) findViewById(R.id.buttonthree);

        textViewFour = (TextView) findViewById(R.id.textView3);
        textViewFive = (TextView) findViewById(R.id.textView4);

        textViewFour.setText(getIntent().getStringExtra("com.example.vellu.androidproject.showthree"));
        textViewFive.setText(getIntent().getStringExtra("com.example.vellu.androidproject.showfour"));

        imageView = (ImageView) findViewById(R.id.imageView);

        Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(imageView);

        goToActivityFour();

    }
    public void goToActivityFour() {
        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ActivityThree.this);

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

                        inputOne = textViewFour.getText().toString();
                        inputTwo = textViewFive.getText().toString();
                        Intent moveTo = new Intent(ActivityThree.this, ActivityFour.class);
                        moveTo.putExtra("com.example.vellu.androidproject.showFive",inputOne);
                        moveTo.putExtra("com.example.vellu.androidproject.showSix",inputTwo);
                        startActivity(moveTo);
                        finish();
                    }
                });
                builder.show();

            }
        });
    }
}
