package com.cloudicalabs.converters.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.cloudicalabs.converters.HomeActivity;
import com.cloudicalabs.converters.R;
import com.cloudicalabs.converters.adapter.GridAdapter;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AllConverters#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AllConverters extends Fragment {

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
     * @return A new instance of fragment AllConverters.
     */
    // TODO: Rename and change types and number of parameters
    public static AllConverters newInstance(String param1, String param2) {
        AllConverters fragment = new AllConverters();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public AllConverters() {
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
        View view = inflater.inflate(R.layout.screen, container, false);
        int[] text = {R.string.temp, R.string.weight, R.string.len, R.string.time, R.string.area, R.string.vol, R.string.store, R.string.prsure, R.string.sound, R.string.ene, R.string.mag, R.string.img};
        int[] imgId = {R.drawable.temperature, R.drawable.food, R.drawable.resize, R.drawable.circular, R.drawable.pie, R.drawable.chemistry, R.drawable.database, R.drawable.blood, R.drawable.sound, R.drawable.energy, R.drawable.magnet, R.drawable.images};

        GridView grid = (GridView) view.findViewById(R.id.grid);
        GridAdapter adapter = new GridAdapter(getContext(), text, imgId);
        grid.setAdapter(adapter);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Fragment fragment = null;
                switch (position) {
                    case 0:
                        fragment = new Temperature();
                        break;
                    case 1:
                        fragment = new Weight();
                        break;
                    case 2:
                        fragment = new Length();
                        break;
                    case 3:
                        fragment = new Time();
                        break;
                    case 4:
                        fragment = new Area();
                        break;
                    case 5:
                        fragment = new Volume();
                        break;
                    case 6:
                        fragment = new Storage();
                        break;
                    case 7:
                        fragment = new Pressure();
                        break;
                    case 8:
                        fragment = new Sound();
                        break;
                    case 9:
                        fragment = new Energy();
                        break;
                    case 10:
                        fragment = new Magnet();
                        break;
                    case 11:
                        fragment = new Image();
                        break;
                }

                ((HomeActivity) getActivity()).openFragment(fragment);

            }
        });
        return view;
    }
}
