package com.example.vellu.androidproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ActivityThree extends Activity{

    Button buttonThree;
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        buttonThree = (Button) findViewById(R.id.buttonthree);

        imageView = (ImageView) findViewById(R.id.imageView);

        Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(imageView);

        goToActivityFour();

    }
    public void goToActivityFour() {
        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveTo = new Intent(ActivityThree.this, ActivityFour.class);
                startActivity(moveTo);
                finish();
            }
        });
    }
}
