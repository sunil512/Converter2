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
import com.cloudicalabs.converters.datahandlers.PressureConverter;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Pressure#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Pressure extends Fragment {

    Spinner psa,psb;
    EditText pe,pee;
    String pfrom,pto;
    PressureConverter pcon;
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
     * @return A new instance of fragment Pressure.
     */
    // TODO: Rename and change types and number of parameters
    public static Pressure newInstance(String param1, String param2) {
        Pressure fragment = new Pressure();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Pressure() {
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
        View view = inflater.inflate(R.layout.pressure, container, false);
        pe = (EditText) view.findViewById(R.id.ped);
        pee = (EditText) view.findViewById(R.id.ped1);
        pcon = new PressureConverter();

        psa = (Spinner) view.findViewById(R.id.pspinner);
        psb = (Spinner) view.findViewById(R.id.pspinner2);
        psa.setAdapter(new CustomSpinnerAdapter(getContext(),R.layout.spinner_item, getResources().getStringArray(R.array.pressureform), "atmosphere"));
        psb.setAdapter(new CustomSpinnerAdapter(getContext(), R.layout.spinner_item, getResources().getStringArray(R.array.pressureform), "bar"));


        pe.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (!pe.getText().toString().equals(""))
                {
                    pfrom = (String) psa.getSelectedItem();
                    pto = (String) psb.getSelectedItem();
                    Double pip = Double.valueOf(pe.getText().toString());
                    PressureConverter.Press fromPress = PressureConverter.Press.fromString(pfrom);
                    PressureConverter.Press toPress = PressureConverter.Press.fromString(pto);
                    Double pop = pcon.PressureConvert(fromPress,toPress,pip);
                    pee.setText(String.valueOf(pop));
                }
                else {
                    pee.setText("");
                }
            }
        });
        return view;
    }


}
