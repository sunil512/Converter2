package com.cloudicalabs.converters.fragments;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import com.cloudicalabs.converters.adapter.CustomSpinnerAdapter;
import com.cloudicalabs.converters.R;
import com.cloudicalabs.converters.datahandlers.TemperatureConverter;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Temperature#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Temperature extends Fragment {

    Spinner sp1,sp2;
    EditText input,result;
    String ufrom,uto;
    TemperatureConverter con;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Temperature.
     */
    // TODO: Rename and change types and number of parameters
    public static Temperature newInstance(String param1, String param2) {
        Temperature fragment = new Temperature();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Temperature() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.temperature, container, false);
        input = (EditText) view.findViewById(R.id.ip);
        result = (EditText) view.findViewById(R.id.res);
        result.setClickable(false);
        con = new TemperatureConverter();

        sp1 = (Spinner) view.findViewById(R.id.spinner);
        sp2 = (Spinner) view.findViewById(R.id.spinner2);
        sp1.setAdapter(new CustomSpinnerAdapter(getContext(), R.layout.spinner_item, getResources().getStringArray(R.array.temperatureform), "Celsius"));
        sp2.setAdapter(new CustomSpinnerAdapter(getContext(), R.layout.spinner_item, getResources().getStringArray(R.array.temperatureform), "Fahrenheit"));

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (!input.getText().toString().equals("")){

                    ufrom = (String) sp1.getSelectedItem();
                    uto = (String) sp2.getSelectedItem();
                    Double ip = Double.valueOf(input.getText().toString());
                    TemperatureConverter.Units fromUnit = TemperatureConverter.Units.fromString(ufrom);
                    TemperatureConverter.Units toUnit = TemperatureConverter.Units.fromString(uto);
                    double r = con.TemperatureConvert(fromUnit,toUnit,ip);
                    result.setText(String.valueOf(r));

                }
                else {
                    result.setText("");
                }

            }
        });
        return view;
    }


}
