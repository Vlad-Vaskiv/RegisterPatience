package com.example.lab1.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lab1.Main.MainActivity;
import com.example.lab1.R;

import timber.log.Timber;

public class Registration extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Timber.i("Opened activity registration");
    }

    // Обработка нажатия кнопки
    public void registration(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        // запуск activity
        startActivity(intent);
        Timber.i("Opened button registration");
    }

    public void onStart(){
        super.onStart();
        Timber.i("onStart");
    }

    public void onResume(){
        super.onResume();
        Timber.i("onResume");
    }

    public void onPause(){
        super.onPause();
        Timber.i("onPause");
    }

    public void onStop(){
        super.onStop();
        Timber.i("onStop");
    }
}