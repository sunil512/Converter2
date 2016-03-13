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
import com.cloudicalabs.converters.datahandlers.SoundConverter;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Sound#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Sound extends Fragment {

    Spinner ssa,ssb;
    EditText sed,sad;
    String sufrom,suto;
    SoundConverter sucon;
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
     * @return A new instance of fragment Sound.
     */
    // TODO: Rename and change types and number of parameters
    public static Sound newInstance(String param1, String param2) {
        Sound fragment = new Sound();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Sound() {
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
        View v = inflater.inflate(R.layout.sound, container, false);
        sed = (EditText) v.findViewById(R.id.sued);
        sad = (EditText) v.findViewById(R.id.sued1);
        sucon = new SoundConverter();

        ssa = (Spinner) v.findViewById(R.id.suspinner);
        ssb = (Spinner) v.findViewById(R.id.suspinner2);
        ssa.setAdapter(new CustomSpinnerAdapter(getContext(),R.layout.spinner_item, getResources().getStringArray(R.array.soundform), "bel"));
        ssb.setAdapter(new CustomSpinnerAdapter(getContext(), R.layout.spinner_item, getResources().getStringArray(R.array.soundform), "decibel"));


        sed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (!sed.getText().toString().equals(""))
                {
                    sufrom = (String) ssa.getSelectedItem();
                    suto = (String) ssb.getSelectedItem();
                    Double suip = Double.valueOf(sed.getText().toString());
                    SoundConverter.Sund fromSund = SoundConverter.Sund.fromString(sufrom);
                    SoundConverter.Sund toSund = SoundConverter.Sund.fromString(suto);
                    Double suop = sucon.SoundConvert(fromSund,toSund,suip);
                    sad.setText(String.valueOf(suop));
                }
                else {
                    sad.setText("");
                }
            }
        });
        return v;
    }


}