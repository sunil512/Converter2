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
import com.cloudicalabs.converters.datahandlers.EnergyConverter;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Energy#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Energy extends Fragment {

    Spinner esp, esp1;
    EditText ea, eb;
    String efrom, eto;
    EnergyConverter econ;
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
     * @return A new instance of fragment Energy.
     */
    // TODO: Rename and change types and number of parameters
    public static Energy newInstance(String param1, String param2) {
        Energy fragment = new Energy();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Energy() {
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
        View v = inflater.inflate(R.layout.energy, container, false);

        ea = (EditText) v.findViewById(R.id.eed);
        eb = (EditText) v.findViewById(R.id.eed1);
        econ = new EnergyConverter();

        esp = (Spinner) v.findViewById(R.id.espinner);
        esp1 = (Spinner) v.findViewById(R.id.espinner2);
        esp.setAdapter(new CustomSpinnerAdapter(getContext(), R.layout.spinner_item, getResources().getStringArray(R.array.energyform), "BritishThermalUnit"));
        esp1.setAdapter(new CustomSpinnerAdapter(getContext(), R.layout.spinner_item, getResources().getStringArray(R.array.energyform), "calories"));

        ea.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (!ea.getText().toString().equals("")) {
                    efrom = (String) esp.getSelectedItem();
                    eto = (String) esp1.getSelectedItem();
                    Double eip = Double.valueOf(ea.getText().toString());
                    EnergyConverter.Ene fromEne = EnergyConverter.Ene.fromString(efrom);
                    EnergyConverter.Ene toEne = EnergyConverter.Ene.fromString(eto);
                    Double eop = econ.EnergyConvert(fromEne, toEne, eip);
                    eb.setText(String.valueOf(eop));
                } else {
                    eb.setText("");
                }
            }
        });

        return v;
    }


}
