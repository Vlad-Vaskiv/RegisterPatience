package com.example.lab1.Menu;

import android.util.Log;
import androidx.lifecycle.ViewModel;
public class SelectDoctorViewModel extends ViewModel{

    public SelectDoctorViewModel()
    {
        Log.i("SelectDoctorViewModel","SelectDoctorViewModel created!");
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i("SelectDoctorViewModel","SelectDoctorViewModel destroyed!");
    }
}
