package com.example.vellu.androidproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import java.util.HashMap;
import java.util.List;

public class ListAdapter extends ArrayAdapter {

    HashMap<Object, Integer> mIdMap = new HashMap<Object, Integer>();


    public ListAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);

        for (int i = 0; i < objects.size() ; ++i) {
            mIdMap.put(objects.get(i), i);
        }
    }

    @Override
    public long getItemId(int position) {
        Object item = getItem(position);
        return mIdMap.get(item);
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
}
