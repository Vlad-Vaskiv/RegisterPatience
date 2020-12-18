package com.example.lab1.Menu;

import android.util.Log;
import androidx.lifecycle.ViewModel;

public class RegistrationViewModel extends ViewModel{
    public RegistrationViewModel()
    {
        Log.i("RegistrationViewModel","RegistrationViewModel created!");
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i("RegistrationViewModel","RegistrationViewModel destroyed!");
    }
}
