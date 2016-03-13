package com.cloudicalabs.converters.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.cloudicalabs.converters.HomeActivity;
import com.cloudicalabs.converters.R;
import com.cloudicalabs.converters.adapter.GridAdapter;

public class AllConverters extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.screen, container, false);
        int[] text = {R.string.temp, R.string.weight, R.string.len, R.string.time, R.string.area, R.string.vol, R.string.store, R.string.prsure, R.string.sound, R.string.ene, R.string.mag, R.string.img};
        int[] imgId = {R.drawable.temperature, R.drawable.food, R.drawable.resize, R.drawable.circular, R.drawable.pie, R.drawable.chemistry, R.drawable.database, R.drawable.blood, R.drawable.sound, R.drawable.energy, R.drawable.magnet, R.drawable.images};

        GridView grid = (GridView) view.findViewById(R.id.grid);
        GridAdapter adapter = new GridAdapter(getContext(), text, imgId);
        grid.setAdapter(adapter);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                UniqueConverter uniqueConverter = UniqueConverter.setArguments(position);
                ((HomeActivity) getActivity()).openFragment(uniqueConverter);

            }
        });
        return view;
    }
}
