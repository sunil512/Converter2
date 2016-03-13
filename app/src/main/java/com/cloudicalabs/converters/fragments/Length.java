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
import com.cloudicalabs.converters.datahandlers.LengthConverter;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Length#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Length extends Fragment {

    Spinner spa,spb;
    EditText input,result;
    String lfrom,lto;
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
     * @return A new instance of fragment Length.
     */
    // TODO: Rename and change types and number of parameters
    public static Length newInstance(String param1, String param2) {
        Length fragment = new Length();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Length() {
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
        View view = inflater.inflate(R.layout.length, container, false);
        input = (EditText) view.findViewById(R.id.led);
        result = (EditText) view.findViewById(R.id.led1);

        spa = (Spinner) view.findViewById(R.id.lsp1);
        spb = (Spinner) view.findViewById(R.id.lsp2);
        spa.setAdapter(new CustomSpinnerAdapter(getContext(), R.layout.spinner_item, getResources().getStringArray(R.array.lengthform), "Kilometers"));
        spb.setAdapter(new CustomSpinnerAdapter(getContext(), R.layout.spinner_item, getResources().getStringArray(R.array.lengthform), "Miles"));

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (!input.getText().toString().equals("")) {
                    lfrom = (String) spa.getSelectedItem();
                    lto = (String) spb.getSelectedItem();
                    double in = Double.valueOf(input.getText().toString());
                    LengthConverter.Leng fromLeng = LengthConverter.Leng.fromString(lfrom);
                    LengthConverter.Leng toLeng = LengthConverter.Leng.fromString(lto);

                    LengthConverter lengthConverter = new LengthConverter(fromLeng, toLeng);
                    double rr = lengthConverter.convert(in);
                    result.setText(String.valueOf(rr));
                } else {
                    result.setText("");
                }
            }
        });
        return view;
    }


}
