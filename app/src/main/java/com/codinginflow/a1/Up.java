package com.codinginflow.a1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.app.Fragment;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

@SuppressLint("NewApi")
public class Up extends Fragment {
Button co;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {// Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragmentup,container,false);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        co = (Button) view.findViewById(R.id.colorup);;
        co.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Down col = (Down) getFragmentManager().findFragmentById(R.id.fragmentdown);
               Bundle b = getArguments();
                String text = null;
                if( b != null ) {
                    text = b.getString("text","num");
                }
                col.change(text);
            }
        });
        return view;
    }
}

