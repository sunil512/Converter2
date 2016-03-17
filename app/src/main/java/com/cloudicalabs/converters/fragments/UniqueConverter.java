package com.cloudicalabs.converters.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.cloudicalabs.converters.R;
import com.cloudicalabs.converters.datahandlers.AreaConverter;
import com.cloudicalabs.converters.datahandlers.EnergyConverter;
import com.cloudicalabs.converters.datahandlers.ImageConverter;
import com.cloudicalabs.converters.datahandlers.LengthConverter;
import com.cloudicalabs.converters.datahandlers.MagnetConverter;
import com.cloudicalabs.converters.datahandlers.PressureConverter;
import com.cloudicalabs.converters.datahandlers.SoundConverter;
import com.cloudicalabs.converters.datahandlers.StorageConverter;
import com.cloudicalabs.converters.datahandlers.TemperatureConverter;
import com.cloudicalabs.converters.datahandlers.TimeConverter;
import com.cloudicalabs.converters.datahandlers.VolumeConverter;
import com.cloudicalabs.converters.datahandlers.WeightConverter;


public class UniqueConverter extends Fragment {

    private Spinner fromDetails, toDetails;
    private EditText fromInput, toInput;


    public static UniqueConverter setArguments(int position) {
        UniqueConverter uniqueConverter = new UniqueConverter();
        Bundle args = new Bundle();
        args.putInt("position", position);
        uniqueConverter.setArguments(args);
        return uniqueConverter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_uniquelayout, container, false);


        onInitVies(view);
        int position = getArguments().getInt("position");

        switch (position) {
            case 0:
                setAdapter(getResources().getStringArray(R.array.temperatureform));
                fromInput.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                        if (!fromInput.getText().toString().equals("")) {
                            String ifrom = (String) fromDetails.getSelectedItem();
                            String ito = (String) toDetails.getSelectedItem();
                            Double inp = Double.valueOf(fromInput.getText().toString());
                            TemperatureConverter con = new TemperatureConverter();
                            TemperatureConverter.Units fromUnit = TemperatureConverter.Units.fromString(ifrom);
                            TemperatureConverter.Units toUnit = TemperatureConverter.Units.fromString(ito);
                            double out = con.TemperatureConvert(fromUnit, toUnit, inp);
                            toInput.setText(String.valueOf(out));
                        } else {
                            toInput.setText("");
                        }

                    }
                });
                break;
            case 1:
                setAdapter(getResources().getStringArray(R.array.weightform));
                fromInput.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                        if (!fromInput.getText().toString().equals("")) {
                            String ifrom = (String) fromDetails.getSelectedItem();
                            String ito = (String) toDetails.getSelectedItem();
                            Double inp = Double.valueOf(fromInput.getText().toString());
                            WeightConverter converter = new WeightConverter();
                            WeightConverter.Inus fromInus = WeightConverter.Inus.fromString(ifrom);
                            WeightConverter.Inus toInus = WeightConverter.Inus.fromString(ito);
                            double out = converter.WeightConvert(fromInus, toInus, inp);
                            toInput.setText(String.valueOf(out));
                        } else {
                            toInput.setText("");
                        }

                    }
                });
                break;
            case 2:
                setAdapter(getResources().getStringArray(R.array.lengthform));
                fromInput.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                        if (!fromInput.getText().toString().equals("")) {
                            String ifrom = (String) fromDetails.getSelectedItem();
                            String ito = (String) toDetails.getSelectedItem();
                            Double inp = Double.valueOf(fromInput.getText().toString());
                            LengthConverter.Leng fromLeng = LengthConverter.Leng.fromString(ifrom);
                            LengthConverter.Leng toLeng = LengthConverter.Leng.fromString(ito);
                            LengthConverter lengthConverter = new LengthConverter(fromLeng, toLeng);
                            double out = lengthConverter.convert(inp);
                            toInput.setText(String.valueOf(out));
                        } else {
                            toInput.setText("");
                        }

                    }
                });
                break;
            case 3:
                setAdapter(getResources().getStringArray(R.array.timeform));
                fromInput.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                        if (!fromInput.getText().toString().equals("")) {
                            String ifrom = (String) fromDetails.getSelectedItem();
                            String ito = (String) toDetails.getSelectedItem();
                            Double inp = Double.valueOf(fromInput.getText().toString());
                            TimeConverter timeConverter = new TimeConverter();
                            TimeConverter.Time fromTime = TimeConverter.Time.fromString(ifrom);
                            TimeConverter.Time toTime = TimeConverter.Time.fromString(ito);
                            double out = timeConverter.TimeConv(fromTime, toTime, inp);
                            toInput.setText(String.valueOf(out));
                        } else {
                            toInput.setText("");
                        }

                    }
                });
                break;
            case 4:
                setAdapter(getResources().getStringArray(R.array.areaform));
                fromInput.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                        if (!fromInput.getText().toString().equals("")) {
                            String ifrom = (String) fromDetails.getSelectedItem();
                            String ito = (String) toDetails.getSelectedItem();
                            Double inp = Double.valueOf(fromInput.getText().toString());
                            AreaConverter aCon = new AreaConverter();
                            AreaConverter.Area fromArea = AreaConverter.Area.fromString(ifrom);
                            AreaConverter.Area toArea = AreaConverter.Area.fromString(ito);
                            double out = aCon.AreaConvert(fromArea,toArea,inp);
                            toInput.setText(String.valueOf(out));
                        } else {
                            toInput.setText("");
                        }

                    }
                });
                break;
            case 5:
                setAdapter(getResources().getStringArray(R.array.volumeform));
                fromInput.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                        if (!fromInput.getText().toString().equals("")) {
                            String ifrom = (String) fromDetails.getSelectedItem();
                            String ito = (String) toDetails.getSelectedItem();
                            Double inp = Double.valueOf(fromInput.getText().toString());
                            VolumeConverter vvon = new VolumeConverter();
                            VolumeConverter.Vol fromVol = VolumeConverter.Vol.fromString(ifrom);
                            VolumeConverter.Vol toVol = VolumeConverter.Vol.fromString(ito);
                            double out = vvon.VolConvert(fromVol, toVol, inp);
                            toInput.setText(String.valueOf(out));
                        } else {
                            toInput.setText("");
                        }

                    }
                });
                break;
            case 6:
                setAdapter(getResources().getStringArray(R.array.storageform));
                fromInput.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                        if (!fromInput.getText().toString().equals("")) {
                            String ifrom = (String) fromDetails.getSelectedItem();
                            String ito = (String) toDetails.getSelectedItem();
                            Double inp = Double.valueOf(fromInput.getText().toString());
                            StorageConverter scon = new StorageConverter();
                            StorageConverter.Store fromStore = StorageConverter.Store.fromString(ifrom);
                            StorageConverter.Store toStore = StorageConverter.Store.fromString(ito);
                            double out = scon.StorageCon(fromStore, toStore, inp);
                            toInput.setText(String.valueOf(out));
                        } else {
                            toInput.setText("");
                        }

                    }
                });
                break;
            case 7:
                setAdapter(getResources().getStringArray(R.array.pressureform));
                fromInput.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                        if (!fromInput.getText().toString().equals("")) {
                            String ifrom = (String) fromDetails.getSelectedItem();
                            String ito = (String) toDetails.getSelectedItem();
                            Double inp = Double.valueOf(fromInput.getText().toString());
                            PressureConverter pcon = new PressureConverter();
                            PressureConverter.Press fromPress = PressureConverter.Press.fromString(ifrom);
                            PressureConverter.Press toPress = PressureConverter.Press.fromString(ito);
                            double out = pcon.PressureConvert(fromPress, toPress, inp);
                            toInput.setText(String.valueOf(out));
                        } else {
                            toInput.setText("");
                        }

                    }
                });
                break;
            case 8:
                setAdapter(getResources().getStringArray(R.array.soundform));
                fromInput.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                        if (!fromInput.getText().toString().equals("")) {
                            String ifrom = (String) fromDetails.getSelectedItem();
                            String ito = (String) toDetails.getSelectedItem();
                            Double inp = Double.valueOf(fromInput.getText().toString());
                            SoundConverter  sucon = new SoundConverter();
                            SoundConverter.Sund fromSund = SoundConverter.Sund.fromString(ifrom);
                            SoundConverter.Sund toSund = SoundConverter.Sund.fromString(ito);
                            double out = sucon.SoundConvert(fromSund, toSund, inp);
                            toInput.setText(String.valueOf(out));
                        } else {
                            toInput.setText("");
                        }

                    }
                });
                break;
            case 9:
                setAdapter(getResources().getStringArray(R.array.energyform));
                fromInput.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                        if (!fromInput.getText().toString().equals("")) {
                            String ifrom = (String) fromDetails.getSelectedItem();
                            String ito = (String) toDetails.getSelectedItem();
                            Double inp = Double.valueOf(fromInput.getText().toString());
                            EnergyConverter econ = new EnergyConverter();
                            EnergyConverter.Ene fromEne = EnergyConverter.Ene.fromString(ifrom);
                            EnergyConverter.Ene toEne = EnergyConverter.Ene.fromString(ito);
                            double out = econ.EnergyConvert(fromEne, toEne, inp);
                            toInput.setText(String.valueOf(out));
                        } else {
                            toInput.setText("");
                        }

                    }
                });
                break;
            case 10:
                setAdapter(getResources().getStringArray(R.array.magnetform));
                fromInput.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                        if (!fromInput.getText().toString().equals("")) {
                            String ifrom = (String) fromDetails.getSelectedItem();
                            String ito = (String) toDetails.getSelectedItem();
                            Double inp = Double.valueOf(fromInput.getText().toString());
                            MagnetConverter mcon = new MagnetConverter();
                            MagnetConverter.Magg fromMagg = MagnetConverter.Magg.fromString(ifrom);
                            MagnetConverter.Magg toMagg = MagnetConverter.Magg.fromString(ito);
                            double out = mcon.MagnetConvert(fromMagg, toMagg, inp);
                            toInput.setText(String.valueOf(out));
                        } else {
                            toInput.setText("");
                        }

                    }
                });
                break;
            case 11:
                setAdapter(getResources().getStringArray(R.array.imageform));
                fromInput.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                        if (!fromInput.getText().toString().equals("")) {
                            String ifrom = (String) fromDetails.getSelectedItem();
                            String ito = (String) toDetails.getSelectedItem();
                            Double inp = Double.valueOf(fromInput.getText().toString());
                            ImageConverter iconn = new ImageConverter();
                            ImageConverter.Img fromImg = ImageConverter.Img.fromString(ifrom);
                            ImageConverter.Img toImg = ImageConverter.Img.fromString(ito);
                            double out = iconn.ImageConvert(fromImg, toImg, inp);
                            toInput.setText(String.valueOf(out));
                        } else {
                            toInput.setText("");
                        }

                    }
                });
                break;
        }



        return view;

    }


    private void setAdapter(String[] spinnerItems) {

        fromDetails.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, spinnerItems) );
        toDetails.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, spinnerItems) );
    }

    private void onInitVies(View view) {
        fromDetails = (Spinner) view.findViewById(R.id.fromSpinner);
        toDetails = (Spinner) view.findViewById(R.id.toSpinner);


        fromInput = (EditText) view.findViewById(R.id.fromInput);
        toInput = (EditText) view.findViewById(R.id.toInput);
    }
}
