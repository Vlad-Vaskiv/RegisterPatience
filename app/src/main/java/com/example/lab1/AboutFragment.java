package com.example.lab1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import java.util.Date;

import timber.log.Timber;

public class AboutFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        return view;
    }

    public  void onStart(){
        super.onStart();
        Timber.i("onStart");
    }

    @Override
    public  void onResume(){
        super.onResume();
        Timber.i("onResume");
    }

    @Override
    public  void onPause(){
        super.onPause();
        Timber.i("onPause");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Timber.i("onDestroy");
    }

    @Override
    public  void onStop(){
        super.onStop();
        Timber.i("onStop");
    }

}