package com.example.vellu.androidproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ListAdapter extends BaseAdapter {

    Context mContext;
    String[] Title;
    int[] Imge;
    LayoutInflater inflater;

    public ListAdapter(Context applicationContext, String[] Title, int[] Imge) {
        this.mContext = mContext;
        this.Title = Title;
        this.Imge = Imge;
        inflater = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return Title.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.list_row, null);
        TextView item = (TextView) convertView.findViewById(R.id.secondLine);
        ImageView image = (ImageView) convertView.findViewById(R.id.pic);
        item.setText(Title[position]);
        image.setImageResource(Imge[position]);
        return convertView;
    }

}
