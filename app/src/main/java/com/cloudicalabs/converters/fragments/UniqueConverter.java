package com.cloudicalabs.converters.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import com.cloudicalabs.converters.R;
import com.cloudicalabs.converters.adapter.CustomSpinnerAdapter;

/**
 * Created by bharath.simha on 13/03/16.
 */
public class UniqueConverter extends Fragment {

    private Spinner fromDetails, toDetails;
    private EditText fromInput, toInput;

    public static UniqueConverter setArguments(int position) {
        UniqueConverter uniqueConverter = new UniqueConverter();
        Bundle args = new Bundle();
        args.putInt("position", position);
        uniqueConverter.setArguments(args);
        return uniqueConverter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_uniquelayout, container, false);

        int position = getArguments().getInt("position");
        onInitVies(view);

        switch (position) {
            case 0:
                setAdapter(getResources().getStringArray(R.array.temperatureform), "Celsius", "Fahrenheit");
                break;
            case 1:
                setAdapter(getResources().getStringArray(R.array.weightform), "Kilograms", "Grams");
                break;
            case 2:
                setAdapter(getResources().getStringArray(R.array.lengthform), "Kilometers", "Miles");
                break;
            case 3:
                setAdapter(getResources().getStringArray(R.array.timeform), "Seconds", "Minutes");
                break;
            case 4:
                setAdapter(getResources().getStringArray(R.array.areaform), "Hectares", "SquareMeters");
                break;
            case 5:
                setAdapter(getResources().getStringArray(R.array.volumeform), "Litres", "Centilitres");
                break;
            case 6:
                setAdapter(getResources().getStringArray(R.array.storageform), "bit", "byte");
                break;
            case 7:
                setAdapter(getResources().getStringArray(R.array.pressureform), "atmosphere", "bar");
                break;
            case 8:
                setAdapter(getResources().getStringArray(R.array.soundform), "bel", "decibel");
                break;
            case 9:
                setAdapter(getResources().getStringArray(R.array.energyform), "BritishThermalUnit", "calories");
                break;
            case 10:
                setAdapter(getResources().getStringArray(R.array.magnetform), "GaussSquareCentimeter", "KiloLine");
                break;
            case 11:
                setAdapter(getResources().getStringArray(R.array.imageform), "twip", "meter");
                break;
        }

        return view;
    }

    private void setAdapter(String[] spinnerItems, String fromDefaultText, String toDefaultText) {
        fromDetails.setAdapter(new CustomSpinnerAdapter(getContext(), R.layout.spinner_item, spinnerItems, fromDefaultText));
        toDetails.setAdapter(new CustomSpinnerAdapter(getContext(), R.layout.spinner_item, spinnerItems, toDefaultText));
    }

    private void onInitVies(View view) {
        fromDetails = (Spinner) view.findViewById(R.id.fromSpinner);
        toDetails = (Spinner) view.findViewById(R.id.toSpinner);

        fromInput = (EditText) view.findViewById(R.id.fromInput);
        toInput = (EditText) view.findViewById(R.id.toInput);
    }
}
