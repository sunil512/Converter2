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
import com.cloudicalabs.converters.datahandlers.TimeConverter;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Time#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Time extends Fragment {

    Spinner spc, spd;
    EditText tip, top;
    String tfrom, tto;
    TimeConverter tcom;
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
     * @return A new instance of fragment Time.
     */
    // TODO: Rename and change types and number of parameters
    public static Time newInstance(String param1, String param2) {
        Time fragment = new Time();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Time() {
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
        View view = inflater.inflate(R.layout.time, container, false);
        tip = (EditText) view.findViewById(R.id.ted);
        top = (EditText) view.findViewById(R.id.ted1);
        top.setClickable(false);
        tcom = new TimeConverter();

        spc = (Spinner) view.findViewById(R.id.tsp);
        spd = (Spinner) view.findViewById(R.id.tsp2);
        spc.setAdapter(new CustomSpinnerAdapter(getContext(), R.layout.spinner_item, getResources().getStringArray(R.array.timeform), "Seconds"));
        spd.setAdapter(new CustomSpinnerAdapter(getContext(), R.layout.spinner_item, getResources().getStringArray(R.array.timeform), "Minutes"));


        tip.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (!tip.getText().toString().equals("")) {

                    tfrom = (String) spc.getSelectedItem();
                    tto = (String) spd.getSelectedItem();
                    Double ipt = Double.valueOf(tip.getText().toString());
                    TimeConverter.Time fromTime = TimeConverter.Time.fromString(tfrom);
                    TimeConverter.Time toTime = TimeConverter.Time.fromString(tto);
                    double rp = tcom.TimeConv(fromTime, toTime, ipt);
                    top.setText(String.valueOf(rp));

                } else {
                    top.setText("");
                }
            }
        });
        return view;
    }


}
