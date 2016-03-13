package com.cloudicalabs.converters.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cloudicalabs.converters.R;

public class GridAdapter extends BaseAdapter {
    private Context mContext;
    private final int[] text;
    private final int[] imageId;

    public GridAdapter(Context c, int[] text, int[] imageId) {
        mContext = c;
        this.imageId = imageId;
        this.text = text;
    }

    @Override
    public int getCount() {
        return text.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            grid = inflater.inflate(R.layout.grid_single, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView) grid.findViewById(R.id.grid_image);
            textView.setText(text[position]);
            imageView.setImageResource(imageId[position]);
        } else {
            grid = (View) convertView;
        }
        return grid;
    }
}
