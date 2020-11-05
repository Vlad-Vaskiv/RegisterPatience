package com.example.lab1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import timber.log.Timber;

public class SelectdoctorFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_selectdoctor, container, false);
//        // получаем объект RadioGroup
//        RadioGroup radGrp = (RadioGroup) view.findViewById(R.id.radios);
//        // обработка переключения состояния переключателя
//        radGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
////            @Override
//////            public void onCheckedChanged(RadioGroup arg0, int id) {
//////                TextView selection = (TextView) view.findViewById(R.id.selection);
//////                switch(id) {
//////                    case R.id.hiru:
//////                        selection.setText("Вибраний Хірург");
//////                        break;
//////                    case R.id.tera:
//////                        selection.setText("Вибраний Терапевт");
//////                        break;
//////                    case R.id.stom:
//////                        selection.setText("Вибраний Стоматолог");
//////                        break;
//////                    default:
//////                        break;
//////                }
//////            }});
        Timber.i("Opened Fragment Select doctor");
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