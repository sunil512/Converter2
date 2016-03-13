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
import com.cloudicalabs.converters.datahandlers.AreaConverter;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Area#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Area extends Fragment {

    Spinner tspa, tspb;
    EditText aip, aop;
    String afrom, ato;
    AreaConverter aCon;

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
     * @return A new instance of fragment Area.
     */
    // TODO: Rename and change types and number of parameters
    public static Area newInstance(String param1, String param2) {
        Area fragment = new Area();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Area() {
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
        View view = inflater.inflate(R.layout.area, container, false);
        aip = (EditText) view.findViewById(R.id.ed1);
        aop = (EditText) view.findViewById(R.id.ed2);
        aCon = new AreaConverter();

        tspa = (Spinner) view.findViewById(R.id.asp1);
        tspb = (Spinner) view.findViewById(R.id.asp2);

        tspa.setAdapter(new CustomSpinnerAdapter(getContext(), R.layout.spinner_item, getResources().getStringArray(R.array.areaform), "" + "Hectares"));
        tspb.setAdapter(new CustomSpinnerAdapter(getContext(), R.layout.spinner_item, getResources().getStringArray(R.array.areaform), "SquareMeters"));

        aip.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (!aip.getText().toString().equals("")) {

                    afrom = (String) tspa.getSelectedItem();
                    ato = (String) tspb.getSelectedItem();
                    Double inp = Double.valueOf(aip.getText().toString());
                    AreaConverter.Area fromArea = AreaConverter.Area.fromString(afrom);
                    AreaConverter.Area toArea = AreaConverter.Area.fromString(ato);

                    double resu = aCon.AreaConvert(fromArea, toArea, inp);
                    aop.setText(String.valueOf(resu));
                } else {
                    aop.setText("");
                }

            }
        });
        return view;
    }


}
