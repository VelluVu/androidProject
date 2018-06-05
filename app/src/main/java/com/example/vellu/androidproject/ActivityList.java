package com.example.vellu.androidproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import java.util.ArrayList;

public class ActivityList extends Activity {

    ListView listView;
    String[] Values = {"Option 1","Option 2","Option 3","Option 4"
            ,"Option 5","Option 6","Option 7","Option 8",};
    int[] DrawableIds = {R.drawable.ic_beach_access_black_24dp,
            R.drawable.ic_beach_access_black_24dp,
            R.drawable.ic_beach_access_black_24dp,
            R.drawable.ic_beach_access_black_24dp,
            R.drawable.ic_beach_access_black_24dp,
            R.drawable.ic_beach_access_black_24dp,
            R.drawable.ic_beach_access_black_24dp,
            R.drawable.ic_beach_access_black_24dp};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        listView = (ListView) findViewById(R.id.listView);
        ListAdapter listAdapter = new ListAdapter(getApplicationContext(), Values, DrawableIds);
        listView.setAdapter(listAdapter);

    }
}