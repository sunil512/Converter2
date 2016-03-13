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
import com.cloudicalabs.converters.datahandlers.WeightConverter;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Weight#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Weight extends Fragment {

    Spinner wsp1,wsp2;
    EditText ip,res;
    String wfrom,wto;
    WeightConverter wcon;
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
     * @return A new instance of fragment Weight.
     */
    // TODO: Rename and change types and number of parameters
    public static Weight newInstance(String param1, String param2) {
        Weight fragment = new Weight();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Weight() {
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
        View view = inflater.inflate(R.layout.weight, container, false);
        ip = (EditText) view.findViewById(R.id.weditTexta);
        res = (EditText) view.findViewById(R.id.wedd);
        res.setClickable(false);
        wcon = new WeightConverter();

        wsp1 = (Spinner) view.findViewById(R.id.wspinnera);
        wsp2 = (Spinner) view.findViewById(R.id.wspinnerb);
        wsp1.setAdapter(new CustomSpinnerAdapter(getContext(), R.layout.spinner_item, getResources().getStringArray(R.array.weightform), "Kilograms"));
        wsp2.setAdapter(new CustomSpinnerAdapter(getContext(), R.layout.spinner_item, getResources().getStringArray(R.array.weightform), "Grams"));


        ip.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (!ip.getText().toString().equals("")){

                    wfrom = (String) wsp1.getSelectedItem();
                    wto = (String) wsp2.getSelectedItem();
                    double inp = Double.valueOf(ip.getText().toString());
                    WeightConverter.Inus fromInus = WeightConverter.Inus.fromString(wfrom);
                    WeightConverter.Inus toInus = WeightConverter.Inus.fromString(wto);
                    double rs = wcon.WeightConvert(fromInus,toInus,inp);
                    res.setText(String.valueOf(rs));
                }
                else {
                    res.setText("");
                }
            }
        });
        return view;
    }


}
