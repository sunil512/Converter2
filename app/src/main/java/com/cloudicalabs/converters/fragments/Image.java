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
import com.cloudicalabs.converters.datahandlers.ImageConverter;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Image#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Image extends Fragment {

    Spinner isp,isp1;
    EditText inp,iop;
    String ifrom,ito;
    ImageConverter iconn;
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
     * @return A new instance of fragment Image.
     */
    // TODO: Rename and change types and number of parameters
    public static Image newInstance(String param1, String param2) {
        Image fragment = new Image();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Image() {
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
        View v = inflater.inflate(R.layout.image, container, false);

        inp = (EditText) v.findViewById(R.id.ied);
        iop = (EditText) v.findViewById(R.id.ied1);
        iconn = new ImageConverter();

        isp = (Spinner) v.findViewById(R.id.ispinner);
        isp1 = (Spinner) v.findViewById(R.id.ispinner2);
        isp.setAdapter(new CustomSpinnerAdapter(getContext(), R.layout.spinner_item, getResources().getStringArray(R.array.imageform), "twip"));
        isp1.setAdapter(new CustomSpinnerAdapter(getContext(), R.layout.spinner_item, getResources().getStringArray(R.array.imageform), "meter"));
        inp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (!inp.getText().toString().equals("")) {
                    ifrom = (String) isp.getSelectedItem();
                    ito = (String) isp1.getSelectedItem();
                    Double iin = Double.valueOf(inp.getText().toString());
                    ImageConverter.Img fromImg = ImageConverter.Img.fromString(ifrom);
                    ImageConverter.Img toImg = ImageConverter.Img.fromString(ito);
                    Double ipo = iconn.ImageConvert(fromImg, toImg, iin);
                    iop.setText(String.valueOf(ipo));
                } else {
                    iop.setText("");
                }
            }
        });
        return v;
    }


}
