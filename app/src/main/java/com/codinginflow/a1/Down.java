package com.codinginflow.a1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;

import android.content.SharedPreferences;
import android.os.Bundle;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

@SuppressLint("NewApi")
public class Down extends Fragment {
    EditText col;
    OnNameSetListener onNameSetListener;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {// Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragmentdown,container,false);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        col = (EditText) view.findViewById(R.id.etdown);
        String name = col.getText().toString();

        Fragment ldf = new Up();
        Bundle bundle = new Bundle();
        bundle.putString("text",name);
        ldf.setArguments(bundle);
        getFragmentManager().beginTransaction().add(R.id.fragmentup,ldf,ldf.getClass().getName()).addToBackStack(null).commit();

        onNameSetListener.setName(name);
        return view;
    }

   public interface OnNameSetListener {
      public void setName(String name);
    }
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        try{onNameSetListener=(OnNameSetListener)activity;}
        catch (Exception e){}
    }
    public void change(String y){
        col.setText(y);
        col.setTextColor(Color.CYAN);
    }
}