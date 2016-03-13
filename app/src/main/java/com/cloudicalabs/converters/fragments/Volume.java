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
import com.cloudicalabs.converters.datahandlers.VolumeConverter;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Volume#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Volume extends Fragment {

    Spinner as,ass;
    EditText giv,tak;
    String vfro,vto;
    VolumeConverter vvon;
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
     * @return A new instance of fragment Volume.
     */
    // TODO: Rename and change types and number of parameters
    public static Volume newInstance(String param1, String param2) {
        Volume fragment = new Volume();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Volume() {
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
        View view = inflater.inflate(R.layout.volume, container, false);
        giv = (EditText) view.findViewById(R.id.ved);
        tak = (EditText) view.findViewById(R.id.ved1);
        vvon = new VolumeConverter();

        as = (Spinner) view.findViewById(R.id.vspinner);
        ass = (Spinner) view.findViewById(R.id.vspinner2);
        as.setAdapter(new CustomSpinnerAdapter(getContext(),R.layout.spinner_item, getResources().getStringArray(R.array.volumeform), "Liters"));
        ass.setAdapter(new CustomSpinnerAdapter(getContext(), R.layout.spinner_item, getResources().getStringArray(R.array.volumeform), "Centiliters"));


        giv.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!giv.getText().toString().equals(""))
                {
                    vfro = (String) as.getSelectedItem();
                    vto = (String) ass.getSelectedItem();
                    Double yip = Double.valueOf(giv.getText().toString());
                    VolumeConverter.Vol fromVol = VolumeConverter.Vol.fromString(vfro);
                    VolumeConverter.Vol toVol = VolumeConverter.Vol.fromString(vto);
                    Double yop = vvon.VolConvert(fromVol,toVol,yip);
                    tak.setText(String.valueOf(yop));
                }
                else {
                    tak.setText("");
                }
            }
        });
        return view;
    }


}
