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

import com.cloudicalabs.converters.R;
import com.cloudicalabs.converters.adapter.CustomSpinnerAdapter;
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
