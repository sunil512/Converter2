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
import com.cloudicalabs.converters.datahandlers.MagnetConverter;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Magnet#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Magnet extends Fragment {

    Spinner msp,msp1;
    EditText min,mou;
    String mfrom,mto;
    MagnetConverter mcon;

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
     * @return A new instance of fragment Magnet.
     */
    // TODO: Rename and change types and number of parameters
    public static Magnet newInstance(String param1, String param2) {
        Magnet fragment = new Magnet();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Magnet() {
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
        View v = inflater.inflate(R.layout.magnet, container, false);
        min = (EditText) v.findViewById(R.id.med);
        mou = (EditText) v.findViewById(R.id.med1);
        mcon = new MagnetConverter();

        msp = (Spinner) v.findViewById(R.id.mspinner);
        msp1 = (Spinner) v.findViewById(R.id.mspinner2);
        msp.setAdapter(new CustomSpinnerAdapter(getContext(), R.layout.spinner_item, getResources().getStringArray(R.array.magnetform), "GaussSquareCentimeter"));
        msp1.setAdapter(new CustomSpinnerAdapter(getContext(), R.layout.spinner_item, getResources().getStringArray(R.array.magnetform), "KiloLine"));

        min.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (!min.getText().toString().equals(""))
                {
                    mfrom = (String) msp.getSelectedItem();
                    mto = (String) msp1.getSelectedItem();
                    Double mip = Double.valueOf(min.getText().toString());
                    MagnetConverter.Magg fromMagg = MagnetConverter.Magg.fromString(mfrom);
                    MagnetConverter.Magg toMagg = MagnetConverter.Magg.fromString(mto);
                    Double mop = mcon.MagnetConvert(fromMagg, toMagg, mip);
                    mou.setText(String.valueOf(mop));
                }
                else {
                    mou.setText("");
                }
            }
        });
        return v;
    }


}
