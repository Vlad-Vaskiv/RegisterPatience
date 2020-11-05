package com.example.lab1;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import timber.log.Timber;


public class RegistrationFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Timber.i("Opened fragment registration");
        return inflater.inflate(R.layout.fragment_registration, container, false);
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