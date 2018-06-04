package com.example.vellu.androidproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ListClass extends Activity {

    ListView listView;
    String[] values = new String[] {"Option 1","Option 2","Option 3","Option 4"
            ,"Option 5","Option 6","Option 7","Option 8",};
    ArrayList<String> list = new ArrayList<String>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);

        listView = (ListView) findViewById(R.id.listView);

        for (int i = 0; i < values.length ; ++i) {
            list.add(values[i]);
        }
        ListAdapter listAdapter = new ListAdapter(this,
                android.R.layout.simple_list_item_1, list);

        listView.setAdapter(listAdapter);

    }
}