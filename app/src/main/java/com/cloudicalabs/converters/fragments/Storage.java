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
import com.cloudicalabs.converters.datahandlers.StorageConverter;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Storage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Storage extends Fragment {

    Spinner san,sam;
    EditText ra,ban;
    StorageConverter scon;
    String sfrom,sto;

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
     * @return A new instance of fragment Storage.
     */
    // TODO: Rename and change types and number of parameters
    public static Storage newInstance(String param1, String param2) {
        Storage fragment = new Storage();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Storage() {
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
        View view = inflater.inflate(R.layout.storage, container, false);
        ra = (EditText) view.findViewById(R.id.sted);
        ban = (EditText) view.findViewById(R.id.sted1);
        scon = new StorageConverter();

        san = (Spinner) view.findViewById(R.id.stspinner);
        sam = (Spinner) view.findViewById(R.id.stspinner2);
        san.setAdapter(new CustomSpinnerAdapter(getContext(),R.layout.spinner_item, getResources().getStringArray(R.array.storageform), "bit"));
        sam.setAdapter(new CustomSpinnerAdapter(getContext(), R.layout.spinner_item, getResources().getStringArray(R.array.storageform), "byte"));


        ra.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (!ra.getText().toString().equals(""))
                {
                    sfrom = (String) san.getSelectedItem();
                    sto = (String) sam.getSelectedItem();
                    Double sip = Double.valueOf(ra.getText().toString());
                    StorageConverter.Store fromStore = StorageConverter.Store.fromString(sfrom);
                    StorageConverter.Store toStore = StorageConverter.Store.fromString(sto);
                    Double sop = scon.StorageCon(fromStore,toStore,sip);
                    ban.setText(String.valueOf(sop));
                }
                else {
                    ban.setText("");
                }
            }
        });
        return view;
    }


}
