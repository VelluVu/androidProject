package com.example.vellu.androidproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ListView;
import android.widget.Toast;

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
    protected void onStart() {
        super.onStart();
        Log.d("ActivityList","Starting");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("ActivityList", "Resuming");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ActivityList", "Restarting");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ActivityList", "Destroying");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ActivityList", "Stopping");
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Log.d("ActivityList", "Creating");

        Toast.makeText(ActivityList.this, R.string.youopnlistact, Toast.LENGTH_SHORT).show();


        listView = (ListView) findViewById(R.id.listView);
        ListAdapter listAdapter = new ListAdapter(getApplicationContext(), Values, DrawableIds);
        listView.setAdapter(listAdapter);

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(ActivityList.this);

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