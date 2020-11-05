package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentTransaction;
import android.content.Intent; // подключаем класс Intent
import android.os.Bundle;
import android.view.View; // подключаем класс View для обработки нажатия кнопки
import android.widget.EditText; // подключаем класс EditText
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {
    public Timer timer = new Timer();
    public final static String K_REV = "k_rev";
    public int revenue=0;
    public final static String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Timber.i("Opened MainActivity");
        timer.startTimerTotal();
        if (savedInstanceState!=null)
        {
            revenue = savedInstanceState.getInt(K_REV, 1);
        }
    }

    public void reg(View view) {
        Intent intent = new Intent(this, Registration.class);
        // запуск activity
        startActivity(intent);
    }

    public void login(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        // Получаем текстовое поле в текущей Activity
        EditText editText = (EditText) findViewById(R.id.log_name);
        // Получае текст данного текстового поля
        String message = editText.getText().toString();
        // Добавляем с помощью свойства putExtra объект - первый параметр - ключ,
        // второй параметр - значение этого объекта
        intent.putExtra(EXTRA_MESSAGE, message);
        // запуск activity
        startActivity(intent);
        Timber.i("Select button login");
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
//        TextView headerView = (TextView) findViewById(R.id.header);
        switch(id){
            case R.id.reg_settings :
                Intent intent = new Intent(this, Registration.class);
                startActivity(intent);
                Timber.i("Select button in menu Registration");
                return true;
            case R.id.doc_settings:
                Intent intent1 = new Intent(this, DisplayMessageActivity.class);
                startActivity(intent1);
                Timber.i("Select button in menu Doctor");
                return true;
            case R.id.exit:
                Timber.i("Select button in menu Exit");
                onDestroy();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void ChangeFragment(View view){
        Fragment fragment;

        if(view == findViewById(R.id.rbutton)){
            fragment = new RegistrationFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.listFragment, fragment);
            ft.commit();
            Timber.i("Change fragment registration");
        }
        if(view == findViewById(R.id.abutton)){
            fragment = new AboutFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.listFragment, fragment);
            ft.commit();
            Timber.i("Change fragment about me");
        }
        if(view == findViewById(R.id.cbutton)){
            fragment = new SelectdoctorFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.listFragment, fragment);
            ft.commit();
            Timber.i("Change fragment select doctor");
        }

    }

    @Override
    public void onStart(){
        super.onStart();
        Timber.i("onStart");
    }

    @Override
    public void onResume(){
        super.onResume();
        Timber.i("onResume");
    }

    @Override
    public void onPause(){
        super.onPause();
        Timber.i("onPause");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Timber.i("onDestroy");
        timer.stopTimerTotal();
    }

    @Override
    public void onStop(){
        super.onStop();
        Timber.i("onStop");
    }

}