package com.example.giaodienchinh;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

public class fragment1 extends Fragment {
    public fragment1()
    {



    }
    Spinner spinnerkhuvuc;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_trang_ca_nhan, container, false);
        String [] values =
                {"TPHCM","Long An","Tien Giang","Binh Phuoc","Binh Duong","Vung Tau","Dak-Lak","Ca Mau",};
        Spinner spinner = (Spinner) v.findViewById(R.id.spinnertinh);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        String [] value =
                {"TPHCM","Long An","Tien Giang","Binh Phuoc","Binh Duong","Hà Nội","Bình Thuận","Vũng Tàu",};
        Spinner spinnerhuyen = (Spinner) v.findViewById(R.id.spinnerhuyen);
        ArrayAdapter<String> adapterhuyen = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, value);
        adapterhuyen.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnerhuyen.setAdapter(adapterhuyen);
        String [] valuexa =
                {"TPHCM","Long An","Tien Giang","Binh Phuoc","Binh Duong","4-8 years","8-15 years","Over 15 years",};
        Spinner spinnerxa = (Spinner) v.findViewById(R.id.spinnerxa);
        ArrayAdapter<String> adapterxa = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, valuexa);
        adapterxa.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnerxa.setAdapter(adapterxa);

        return  v;


    }
}
